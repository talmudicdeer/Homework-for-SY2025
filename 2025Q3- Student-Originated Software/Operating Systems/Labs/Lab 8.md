Alexis Baker


Operating Systems


Lab 8


05/20/2026

For this lab, I did questions 1 and 2.


### Question 1

Here's the code itself, called `customstat`:

```c
#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <time.h>

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <pathname>\n", argv[0]);
        return 1;
    }

    struct stat sb;

    if (stat(argv[1], &sb) == -1) {
        perror("stat");
        return 1;
    }

    printf("File: %s\n", argv[1]);
    printf("Size: %lld bytes\n", (long long) sb.st_size);
    printf("Blocks Allocated: %lld\n", (long long) sb.st_blocks);
    printf("Link Count: %ld\n", (long) sb.st_nlink);
    printf("Inode Number: %ld\n", (long) sb.st_ino);
    
    printf("File Type: ");
    if (S_ISREG(sb.st_mode))  printf("Regular file\n");
    else if (S_ISDIR(sb.st_mode))  printf("Directory\n");
    else if (S_ISLNK(sb.st_mode))  printf("Symbolic link\n");
    else                           printf("Other\n");

    return 0;
}
```

**What's going on here?** So to begin with, the base link count of a directory, with nothing else in it, is 2. One link is from the entry naming this directory, and the second is the internal entry referring to itself.

Additionally (heh), adding normal files to a directory does not increase its link count, but adding subdirectories does. (This is how, if you're a Linux user, you can ascend up the folder ladder by using `..` in the terminal. Not the same exact thing, but rooted in it, if that makes sense.)

So to answer the question, the **link count** is the total number of subdirectories specifically, plus 2.


### Question 2

Here's the code itself, called `customls`:

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <dirent.h>
#include <unistd.h>
#include <pwd.h>
#include <grp.h>

void print_detailed(const char *dir_path, const char *file_name) {
    struct stat sb;
    char full_path[1024];
    
    snprintf(full_path, sizeof(full_path), "%s/%s", dir_path, file_name);

    if (stat(full_path, &sb) == -1) {
        perror("stat");
        return;
    }

    printf("%c", S_ISDIR(sb.st_mode) ? 'd' : '-');
    printf("%c", (sb.st_mode & S_IRUSR) ? 'r' : '-');
    printf("%c", (sb.st_mode & S_IWUSR) ? 'w' : '-');
    printf("%c", (sb.st_mode & S_IXUSR) ? 'x' : '-');
    printf("%c", (sb.st_mode & S_IRGRP) ? 'r' : '-');
    printf("%c", (sb.st_mode & S_IWGRP) ? 'w' : '-');
    printf("%c", (sb.st_mode & S_IXGRP) ? 'x' : '-');
    printf("%c", (sb.st_mode & S_IROTH) ? 'r' : '-');
    printf("%c", (sb.st_mode & S_IWOTH) ? 'w' : '-');
    printf("%c", (sb.st_mode & S_IXOTH) ? 'x' : '-');

    printf(" %2ld", (long) sb.st_nlink);

    struct passwd *pw = getpwuid(sb.st_uid);
    if (pw) printf(" %s", pw->pw_name);
    else    printf(" %d", sb.st_uid);

    struct group *gr = getgrgid(sb.st_gid);
    if (gr) printf(" %s", gr->gr_name);
    else    printf(" %d", sb.st_gid);

    printf(" %8lld %s\n", (long long) sb.st_size, file_name);
}

int main(int argc, char *argv[]) {
    int long_format = 0;
    char *dir_to_read = NULL;

    for (int i = 1; i < argc; i++) {
        if (strcmp(argv[i], "-l") == 0) {
            long_format = 1;
        } else {
            dir_to_read = argv[i];
        }
    }

    if (dir_to_read == NULL) {
        dir_to_read = ".";
    }

    DIR *dir = opendir(dir_to_read);
    if (dir == NULL) {
        perror("opendir");
        return 1;
    }

    struct dirent *entry;
    while ((entry = readdir(dir)) != NULL) {
        if (entry->d_name[0] == '.') {
            continue;
        }

        if (long_format) {
            print_detailed(dir_to_read, entry->d_name);
        } else {
            printf("%s\n", entry->d_name);
        }
    }

    closedir(dir);
    return 0;
}
```

Both files compiled with no issues and `customls` passed testing.