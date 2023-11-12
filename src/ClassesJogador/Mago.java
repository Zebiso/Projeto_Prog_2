package ClassesJogador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mago extends Jogador{
    protected static double dano = 15;
    protected static double hp = 15;
    protected static double st = 10;
    protected static Integer nivel = 1;
    protected static double exp= 0;
    protected static double min_exp = nivel* 15;
    protected String nomeItem;
    protected double danoItem;
    protected double hpItem;
    protected double stItem;
    protected static List<String> inventarioNome =  new ArrayList<>();
    protected static List<Double> inventarioDano = new ArrayList<>();


    public Mago(String nome) {
        super(nome);
    }

    @Override
    public void equiparItem() {
        this.mostrarInventario();
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        for (int i = 0; i < inventarioDano.size(); i++){
            if (escolha == i){
                inventarioDano.get(i);
            } else {
                System.out.println("Opção inválida.");
                this.equiparItem();
            }
        }

    }

    @Override
    public double causarDano() {
        return dano + this.danoItem;
    }

    @Override
    public double usarSt() {
        this.st -= 4;
        return this.dano + 4;
    }

    @Override
    public double receberDano(double dano) {
        this.hp -= dano;
        return this.hp;
    }

    @Override
    public
    double mostrarHp() {
        return this.hp;
    }

    @Override
    public
    double mostrarDano() {
        return dano;
    }

    @Override
    public double mostrarSt() {
        return this.st;
    }

    @Override
    public
    void aumentarDano(double item) {
        dano += item;
    }

    @Override
    public void aumentarHp(double item) {
    }

    @Override
    public void aumentarSt(double item) {

    }

    @Override 
    public String aumentarNivel(double experi){ //mostrarExp() como parâmentro
        exp += experi;
        System.out.println("Minimo necessário para passar de nivel: " + min_exp);
        System.out.println("Você ganhou " + experi + " de Experiência!!!!!!!!!!!");
        if (exp > min_exp){
            System.out.println("!!!!!!!! Você passou de nivel !!!!!!!");
            exp -= min_exp;
            nivel +=1;
            min_exp = nivel*8;
            System.out.println("Você está no nivel " + nivel);
            System.out.println("Você possui " + exp +" no nivel " + nivel);
            System.out.println("Você precisa de " + min_exp + " Para ir ao próximo nivel!!!!!!!!!!!");

        } else {
            System.out.println("Você precisa de " + (min_exp - exp) + " para passar de nivel");
        }
        return "";
    }

    @Override
    public Integer mostrarNivel(){
        return this.nivel;
    }

    @Override
    public 
    void aumentarExp(double exper){
    }

    @Override
    public double mostrarExp(){
        return exp;
    }

    @Override
    public void item(double dano, String nome, String tipo) {
        if (tipo == "dano") {
            this.danoItem = dano;
            this.nomeItem = nome;
        } else if (tipo == "hp"){
            this.hpItem = dano;
            this.nomeItem = nome;
        } else {
            this.stItem = dano;
            this.nomeItem = nome;
        }
        inventarioNome.add(nome);
        inventarioDano.add(dano);
    }

    @Override
    public double getDanoItem() {
        return this.danoItem;
    }

    @Override
    public double getHpItem() {
        return this.hpItem;
    }

    @Override
    public double getStItem() {
        return this.stItem;
    }

    @Override
    public String getNomeItem() {
        return this.nomeItem;
    }

    @Override
    public void mostrarInventario() {
        System.out.println("Você tem os seguintes itens no iventário: ");
        for (String item : inventarioNome) {
            System.out.println("1 ---> " + item);
        }
    }


}
