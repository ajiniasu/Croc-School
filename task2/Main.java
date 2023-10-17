/**
 *Программа проверяет работу написанных классов,
 * создано 2 подкласса класс музыкальный центр и 2 подкласса класса проигрыватель.
 * классы с припиской являются подклассами класса MusicCenter , а класса с припиской reader
 * подклассы класса MusicCarry
 * @author Dmitriy Sivyy(LogicOfGreen)
 *
 */
public class Main {
    public static void main(String[] args) {
        //Проверяем вариант , если проигрыватель и носитель не подходят друг другу
        Record one = new Record();
        CDPlayer vp=new CDPlayer();
        vp.Connect(one);
        //Проверяем вариант , если проигрыватель и носитель подходят друг другу
        Record two = new Record();
        VinylPlayer vp1=new VinylPlayer();
        vp1.Connect(two);
    }
}