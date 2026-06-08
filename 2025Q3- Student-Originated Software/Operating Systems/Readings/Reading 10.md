Alexis Baker


Operating Systems


Reading 10


**Assume there are many more writes to a file system than reads, how does a log file system take advantage of that?** Through writing to disk sequentially, writing to the end of a find and marking the old section as invalid rather than find-and-replace, and being able to recover lost data from a crash faster.

**Why is finding inodes more difficult in a log file system?** Since nothing is ever overwritten, inodes move all over the place within the disk.

**What is RAID-1 mirroring?** Writing the same thing to two (or more) different disks.

**What is the consistent update problem for RAID?** When writing is interrupted by a crash or similar catastrophe and the parallelity of the writing is corrupted.

**What is RAID-4 with parity?** A disk array setup where one drive is the designated parity drive, which can be used to reconstruct lost data in the other drives in the setup through checking.

**What is a cryptographic hash function?** An algorithm that can take pretty much any input and spit it out in the form of a fixed-size character string.

**What is a dictionary attack?** One step up from brute force entry. Instead of breaking through a door with an axe, a cracker has what is essentially several thousand keys in the form of words.

**What is a salt in a password file?** A unique string of data inserted in someone's normal password to defend against cracking attempts.

**What questions do you have about the reading?** Can I just... salt my passwords myself, or is that something the website itself does?
