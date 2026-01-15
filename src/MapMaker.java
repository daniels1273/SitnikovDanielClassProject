public class MapMaker {

    private String[][] map;
    private int rows;
    private int columns;

    public MapMaker() {
        rows = 5;
        columns = 21;
        map = new String[rows][columns];
        for (int rows = 0; rows < this.rows; rows++){
            for (int columns = 0; columns < this.columns; columns++){
                if (columns == 0){
                    map[rows][columns] = "~";
                } else {
                    map[rows][columns] = "-";
                }
            }
        }
    }

    public void printMap(){
        for (int rows = 0; rows < 5; rows++){
            for (int columns = 0; columns < 20; columns++){
                System.out.print(map[rows][columns]);
            }
            System.out.println();
        }
    }

    public void setCoord(int x, int y, String str){
        map[y][x] = str;
    }

    public String getCurIndex(int x, int y){
        return map[y][x];
    }

    public int getMaxRows(){
        return rows;
    }

    public int getMaxColumns(){
        return columns;
    }

    public String genChar(){
        int r = (int) (Math.random() * 10) + 1;
        if (r >= 6){
            return ".";
        } else if (r > 3) {
            return "~";
        } else {
            return "-";
        }
    }
}