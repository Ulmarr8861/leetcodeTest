package Leet006;

public class AddBlankTest {
    public static void main(String[] args) {
        AddBlankTest a = new AddBlankTest();
        a.Main();
    }
    private String str = "你好";
    public void Main() {
        addBlank(str,5);
        System.out.println(str);
    }
    public void addBlank(String s,int n){
        str = String.format("% 4s", s);
    }
}
