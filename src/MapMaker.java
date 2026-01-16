public class MapMaker {

    private String[][] map;
    private int rows;
    private int columns;
    private int randDangerRow;
    private int randDangerCol;

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

    public void makeHazard1(){
        randDangerRow = (int) (Math.random() * 3);
        randDangerCol = (int) (Math.random() * 13) + 1;
        for (int row = randDangerRow; row < randDangerRow + 3; row++){
            for (int col = randDangerCol; col < randDangerCol + 8; col++){
                map[row][col] = "!";
            }
        }
    }

    public void makeHazard2(){
        for (int row = randDangerRow; row < randDangerRow + 3; row++){
            for (int col = randDangerCol; col < randDangerCol + 8; col++){
                map[row][col] = " ";
            }
        }
    }

    public void makeHazard3(){
        for (int row = randDangerRow; row < randDangerRow + 3; row++){
            for (int col = randDangerCol; col < randDangerCol + 8; col++){
                map[row][col] = "O";
            }
        }
    }

    public void clearHazard(){
        for (int row = randDangerRow; row < randDangerRow + 3; row++){
            for (int col = randDangerCol; col < randDangerCol + 8; col++){
                map[row][col] = "-";
            }
        }
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