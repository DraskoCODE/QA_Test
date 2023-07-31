package test1;

public class Ucenik extends People{

    private String skola;

    public String getSkola() {
        return skola;
    }

    public void setSkola(String skola) {
        this.skola = skola;
    }

    public void printSkola() {
        System.out.println(skola);
    }
}
