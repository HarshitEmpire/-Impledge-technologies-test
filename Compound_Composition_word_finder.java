import  java.io.* ;
import  java.util.* ;

public class Compound_Composition_word_finder {
    public static void main(String[] args)  {
         try  {

             long Start_Time1 =System.currentTimeMillis( );
             processFile("Input_01.txt" );
             long End_Time1 =System.currentTimeMillis( );
             System.out.println("Timetaken by file_Input_1: "+(End_Time1-Start_Time1)+" ms");
             System.out.println( );

            long Start_Time2 =System.currentTimeMillis( );
            processFile("Input_02.txt" );
            long End_Time2 =System.currentTimeMillis( );
            System.out.println("Timetaken by file_Input_2: " + (End_Time2 - Start_Time2) + " ms");

         } catch ( IOException e ) {
            System .err. println( "Error reading file: "+e.getMessage( ));
        }
    }

    private static void processFile( String fileName ) throws IOException {
        List<String> words = new ArrayList<>( );
        try (BufferedReader reader =new BufferedReader( new FileReader( fileName ) ) ) {
            String line;
            while (( line = reader.readLine( ))!=null) 
        {
                words.add( line );
            }
        }

        

        List< String > Lex_Sorted = new ArrayList<>(words);
        Collections.sort( Lex_Sorted ) ;

        

        List<String> length__Sorted = new ArrayList<>(words);
        length__Sorted.sort((a, b) -> Integer.compare(b.length( ),a.length( ) ) );


        String longest ="" ;
        String secondLongest ="" ;


        for (String word:length__Sorted) {
            if (isCompound(word, Lex_Sorted, word)) {
                if (longest.isEmpty()) {
                    longest = word;
                } else if (secondLongest.isEmpty()) {
                    secondLongest = word;
                    break; 
                }
            }
        }

        System.out.println( "Longest_Compound_Word: "+longest );
        System.out.println( "SecondLongest_Compound_Word: "+secondLongest );
    }

    private static boolean isCompound(String word, List<String> Lex_Sorted, String original__Word) {
        if (word.length() == 0) return false;

        for ( int split=1;split<word.length();split++ ){
            String prefix = word.substring(0,split);
            String suffix = word.substring(split);

            
            int prefix_Idx = Collections.binarySearch(Lex_Sorted, prefix);
            if (prefix_Idx < 0 || prefix.equals( original__Word )) 
            continue;

            
            int suffix_Idx =Collections.binarySearch( Lex_Sorted,suffix );
            if (suffix_Idx >= 0&&!suffix.equals(original__Word)) {
                return true;
            }

            if (isCompound(suffix, Lex_Sorted, original__Word)) {
                return true;
            }
        }
        return false;
    }
}