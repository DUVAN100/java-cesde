package co.edu.cesde;

public class Carro {
    private String color;
    public String marca, diseno, placa;

    void encender(){
        System.out.println("Encendiendo");
    }
    void transladar(){
        System.out.println("Transladando");
    }
    void acelerar(){
        System.out.println("Acelerando");
    }
    void setColor(String color){
        if(color.equals("rosado")){
            System.out.println("Oiste no pe" +
                    "uede ser rosado");
        }
        else{
            this.color = color;
        }
    }
    void showColor(){
        System.out.println("su color es"+ this.color);
    }
    String getColor(){
        return this.color;
    }
}
