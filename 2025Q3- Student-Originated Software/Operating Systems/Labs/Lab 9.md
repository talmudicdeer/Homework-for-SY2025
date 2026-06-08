Alexis Baker


Operating Systems


Lab 9


For this lab, I did question 3.


### Question 3

First, as usual the code. It's called, somewhat predictably at this point, `customtail`.

```c
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>

#define BLOCK_SIZE 4096

void print_last_lines(const char *filename, int total_lines_requested) {
    int fd = open(filename, O_RDONLY);
    if (fd < 0) {
        perror("Error opening file");
        exit(EXIT_FAILURE);
    }

    struct stat st;
    if (fstat(fd, &st) < 0) {
        perror("Error stating file");
        close(fd);
        exit(EXIT_FAILURE);
    }

    off_t file_size = st.st_size;
    if (file_size == 0) {
        close(fd);
        return;
    }

    char buffer[BLOCK_SIZE];
    off_t offset = file_size;
    int lines_counted = 0;
    off_t target_pos = 0;
    int found = 0;

    int is_first_block = 1;

    while (offset > 0 && !found) {
        size_t bytes_to_read = (offset > BLOCK_SIZE) ? BLOCK_SIZE : offset;
        offset -= bytes_to_read;

        if (lseek(fd, offset, SEEK_SET) == (off_t)-1) {
            perror("Error seeking");
            close(fd);
            exit(EXIT_FAILURE);
        }

        if (read(fd, buffer, bytes_to_read) != (ssize_t)bytes_to_read) {
            perror("Error reading file");
            close(fd);
            exit(EXIT_FAILURE);
        }

        for (int i = (int)bytes_to_read - 1; i >= 0; i--) {
            if (is_first_block && i == (int)bytes_to_read - 1 && buffer[i] == '\n') {
                is_first_block = 0;
                continue;
            }
            is_first_block = 0;

            if (buffer[i] == '\n') {
                lines_counted++;
                if (lines_counted == total_lines_requested) {
                    target_pos = offset + i + 1;
                    found = 1;
                    break;
                }
            }
        }
    }

    if (!found) {
        target_pos = 0;
    }

    if (lseek(fd, target_pos, SEEK_SET) == (off_t)-1) {
        perror("Error seeking to target position");
        close(fd);
        exit(EXIT_FAILURE);
    }

    ssize_t bytes_read;
    while ((bytes_read = read(fd, buffer, BLOCK_SIZE)) > 0) {
        if (write(STDOUT_FILENO, buffer, bytes_read) != bytes_read) {
            perror("Error writing to stdout");
            close(fd);
            exit(EXIT_FAILURE);
        }
    }

    close(fd);
}

int main(int argc, char *argv[]) {
    if (argc != 4 || argv[1][0] != '-') {
        fprintf(stderr, "Usage: %s -n <num_lines> <filename>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    int num_lines = atoi(&argv[1][1]);
    if (num_lines <= 0) {
        fprintf(stderr, "Invalid number of lines.\n");
        exit(EXIT_FAILURE);
    }

    const char *filename = argv[2];
    print_last_lines(filename, num_lines);

    return 0;
}
```

And it passed testing:

```bash
[magicantean@stafford ~]$ nano customtail.c
[magicantean@stafford ~]$ gcc -Wall -o customtail customtail.c
[magicantean@stafford ~]$ seq 1 15 > test.txt
[magicantean@stafford ~]$ ./customtail -5 test.txt
Usage: ./customtail -n <num_lines> <filename>
[magicantean@stafford ~]$ 
```