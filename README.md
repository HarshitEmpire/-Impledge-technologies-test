# -Impledge-technologies-test
Solution of the question "Compound_Composition_word_finder" in java language

Overview--------------       
The program reads two input files (Input_01.txt and Input_02.txt) containing a list of alphabetically sorted words, and identifies the longest and second longest compound words in each file.       

Steps to Execute--------------      
Compile the program: javac CompoundWords.java     
Run the Program: java CompoundWords     

The program will--------------     
Read the files Input_01.txt and Input_02.txt.     
Identify the longest and secondlongest compound words.     
Display the compound words along with the time taken to process each file.      

Example Output--------------      

Longest Compound Word: ratcatdogcat      
Second Longest Compound Word: catsdogcats      
Time taken for Input_01.txt: 12 ms      

Longest Compound Word: ethylenediaminetetraacetates      
Second Longest Compound Word: electroencephalographically      
Time taken for Input_02.txt: 864 ms      


Approach--------------        
Data Structure: Using binary search    
Compounded_Word Check: For each word in the list, the program checks whether it can be formed by concatenating other words using recursion and memoization. Memoization ensures that already processed words are not checked again, improving performance.      
Design: Program processes each word and keeps track of the longest and second longest compound words as it iterates through the list.     
Performance: Program is optimized to handle large input files efficiently by reducing redundant checks with memoization and fast searching.      


Files--------------     
Compound_Composition_word_finder.java: The main program file.     
Input_01.txt and Input_02.txt: Input files containing sorted word lists.     



