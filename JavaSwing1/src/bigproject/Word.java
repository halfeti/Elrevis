package bigproject;

public class Word {
    public String name, meanning, link, lastTime, restTime;

    public Word(String describedLine) {
        String[] detail = new String[5];
        String cell = "";
        int cellIndex = 0;
                
        for(int i=0; i < describedLine.length(); i++) {
            if(describedLine.charAt(i) != '\t') {
                cell += describedLine.charAt(i);
            } else {
                detail[cellIndex] = cell;
                cell = "";
                cellIndex++;
            }
        }
        
        this.name = detail[0];
        this.meanning = detail[1];
        this.link = detail[2];
        this.lastTime = detail[3];
        this.restTime = detail[4];
    }
    
    public Word(String[] detail) {
        this.name = detail[0];
        this.meanning = detail[1];
        this.link = detail[2];
        this.lastTime = detail[3];
        this.restTime = detail[4];
    }

    public Word(String name, String meanning, String link, String lastTime, String restTime) {
        this.name = name;
        this.meanning = meanning;
        this.link = link;
        this.lastTime = lastTime;
        this.restTime = restTime;
    }
    
    

//    public static void add(Word a) {
//        
//    }
//    
//    public static void remove(Word a) {
//        
//    }
    
    public String toLine() {
        String line = name + "\t" + meanning + "\t" + link + "\t" + lastTime + "\t" + restTime + "\t\r\n";
        
        return line;
    }
    
}
