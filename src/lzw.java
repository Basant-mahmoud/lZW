import java.util.ArrayList;

public class lzw{
    int[] arr=new int[200];
    ArrayList<dictionary> mydic = new ArrayList<dictionary>();
    dictionary newdic;
    private int counter=0;
    private static int cntdic=128;
    int pnt=0;
    public void compresion(String code) {
        code+='$';
        for (int i = 0; i < code.length()-1; i++) {
            int nextfi = i + 2;
            int catchpointer = -1;
            int pnt=0;
            if (i == 0) {
                arr[counter] = (int) code.charAt(i);// put ascii code in arr
                newdic = new dictionary(cntdic, code.substring(i,nextfi ));// Create dic with 128 index and frist two char
                mydic.add(newdic);
                counter++;
                cntdic++;
                continue;
            }
            for ( int j=0;j<mydic.size();j++) {
                if ( code.substring(i, nextfi).equals(mydic.get(j).name)== true ) {///
                    catchpointer = mydic.get(j).position;
                    pnt=nextfi-1;
                    nextfi++;
                }

            }
            if (catchpointer == -1) {
                arr[counter] = (int) code.charAt(i);
                counter++;
                newdic = new dictionary(cntdic, code.substring(i,nextfi));
                //System.out.println( "=  "+ newdic.name);
                mydic.add(newdic);
                cntdic++;
            }
            else {
                arr[counter] = catchpointer;
                counter++;
                newdic = new dictionary(cntdic, code.substring(i, nextfi));
                //System.out.println( "=  "+ newdic.name);
                mydic.add(newdic);
                cntdic++;
                i=pnt;
            }
        }
        for(int i=0;i<counter;i++){
            System.out.println(arr[i]);
        }
    }
    class dictionary {

        int position;
        String name;

        //Constructor
        dictionary(int position, String name) {
            this.position = position;
            this.name = name;
        }
    }
}