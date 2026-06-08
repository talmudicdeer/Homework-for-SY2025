Alexis Baker


Operating Systems


Lab 10


And for this lab, it's question 4.


### Question 4

I present to you `customfind`:

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>
#include <sys/stat.h>
#include <unistd.h>

typedef struct {
    char *name_filter;
    char type_filter; // 'f' for file, 'd' for directory, 0 for any
} FindOptions;

void search_directory(const char *dir_path, const FindOptions *opts) {
    DIR *dir = opendir(dir_path);
    if (!dir) {
        perror(dir_path);
        return;
    }

    struct dirent *entry;
    struct stat st;
    char path[PATH_MAX];

    while ((entry = readdir(dir)) != NULL) {

        if (strcmp(entry->d_name, ".") == 0 || strcmp(entry->d_name, "..") == 0) {
            continue;
        }

        snprintf(path, sizeof(path), "%s/%s", dir_path, entry->d_name);

        if (lstat(path, &st) == -1) {
            perror(path);
            continue;
        }

        int match = 1;

        if (opts->type_filter == 'd' && !S_ISDIR(st.st_mode)) match = 0;
        if (opts->type_filter == 'f' && !S_ISREG(st.st_mode)) match = 0;

        if (opts->name_filter && strstr(entry->d_name, opts->name_filter) == NULL) {
            match = 0;
        }

        if (match) {
            printf("%s\n", path);
        }

        if (S_ISDIR(st.st_mode)) {
            search_directory(path, opts);
        }
    }

    closedir(dir);
}

int main(int argc, char *argv[]) {
    char *starting_point = "."; // Default to Current Working Directory
    FindOptions opts = {NULL, 0};
    int arg_idx = 1;

    if (argc > 1 && argv[1][0] != '-') {
        starting_point = argv[1];
        arg_idx = 2;
    }

    for (; arg_idx < argc; arg_idx++) {
        if (strcmp(argv[arg_idx], "-name") == 0 && arg_idx + 1 < argc) {
            opts.name_filter = argv[++arg_idx];
        } else if (strcmp(argv[arg_idx], "-type") == 0 && arg_idx + 1 < argc) {
            char t = argv[++arg_idx][0];
            if (t == 'f' || t == 'd') {
                opts.type_filter = t;
            } else {
                fprintf(stderr, "Unknown type: %s (use 'f' or 'd')\n", argv[arg_idx]);
                exit(EXIT_FAILURE);
            }
        } else {
            fprintf(stderr, "Usage: %s [path] [-name <str>] [-type <f|d>]\n", argv[0]);
            exit(EXIT_FAILURE);
        }
    }

    if (opts.type_filter != 'f') {
        printf("%s\n", starting_point);
    }

    search_directory(starting_point, &opts);

    return 0;
}
```

So, some explanations are in order here, I believe.

I included chunks that can filter for name and type, to add a little versatility to the program. Figured I should try out something more than just the bare necessities.

I liked how cheeky the question was about important interfaces: figure it out, so I did:

- `opendir()`/`closedir()`: crucial for, well, opening and closing directory streams.
- `readdir()`: so the program can go through entries in a directory
- `lstat()`: preferred over `stat()` in this particular instance so we don't cause infinite loops by stepping on a symbolic link.

**Test Results**

**Compile test:**

```bash
[magicantean@stafford ~]$ gcc -Wall -o customfind customfind.c
[magicantean@stafford ~]$ 
```

**Test #1: running without any arguments**

it, uh... it worked. That's all I'm saying there. (It gave me literally the entire contents of my computer.)

**Test #2: running on a specific directory**

Yep, it uh, also worked. (I forgot how many files are just hanging out on a Linux system.)