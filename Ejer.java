class Ejer{
    static ArrayList<String> plays = new ArrayList<String>();
    static int pe, eli;
    static String ac;

    public static void ped() {
        try {
            pe = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido escoja que quiere hacer \n  Ver : 1    Agregar : 2  \n  Borrar : 3   Actualizar :4"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO PUEDE INGRESAR ESO");
            ped();
        }
    }

    public static void lis() {
        JOptionPane.showConfirmDialog(null, plays);
    }

    public static void ver() {
        lis();
    }

    public static void agre() {
        do {
            plays.add(JOptionPane.showInputDialog("Agrega tu cancione"));
        } while (JOptionPane.showConfirmDialog(null, "Quieres repetir?", null, 0, JOptionPane.YES_NO_OPTION) == 0);

    }

    public static void act() {
        ac =JOptionPane.showInputDialog("Desea acuatilzar una canción?").toLowerCase();
        if("si".equals(ac)){
            if(plays.size()>1){
                eli = Integer.parseInt(JOptionPane.showInputDialog("Escoja la posición de la canción a actualizar \n"+plays));
                plays.set((eli-1), JOptionPane.showInputDialog("Actalize su canción"));
            } else if(plays.size()==0)
                JOptionPane.showConfirmDialog(null, "Solo se puede actualizar con mas de 2 canción", null,0);
        } else if("no".equals(ac)){
            
        }
        
            
        
    }

    public static void borr() {
        try {
            eli = Integer.parseInt(JOptionPane.showInputDialog("Desea borrar \n todas sus canciones : 1  o solo una canción : 2 "));
            if (eli == 1) {
                plays.clear();

            } else if ( eli == 2) {
                 if(plays.size() > 1){
                    eli = Integer.parseInt(JOptionPane.showInputDialog("Eligue la canción a eliminar en su posición \n"+plays));
                    plays.remove(eli-1);
            } else if(plays.size()==0){
                JOptionPane.showConfirmDialog(null, "NO TIENES NINGUNA CANCIÖN");
            }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO PUEDE INGRESAR ESO");
        }
    }

    public static void men() {

        switch (pe) {
            case 1:
                ver();
                break;
            case 2:
                agre();
                ped();
                men();
                break;
            case 3:
                borr();
                ped();
                men();
                break;
            case 4:
                act();
                ped();
                men();
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        do {
            ped();
            if (pe < 5) {
                men();
            }  
        } while (JOptionPane.showConfirmDialog(null, "Quieres repetir?", null, 0, JOptionPane.YES_NO_OPTION) == 0);
    }
}