import javax.swing.text.View;
import java.util.Scanner;

public class AppTodoList {

    public static String[] model = new String[10];
    public static Scanner scanner =  new Scanner(System.in);



    public static void main(String[] args) {
        viewShowTodoList();

    }

    public static void showTodoList() {
        for(var i = 0; i <model.length; i++) {
             var todo = model[i];
             var no = i + 1;

             if(todo != null) {
                 System.out.println(no + ". " + todo);
             }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi kasus java dasar : Aplikasi TodoList";

        showTodoList();
    }

    public static void addTodoList(String todo) {
        //cek apakah model penuh
        boolean isFull = true;
        for(int i = 0; i < model.length; i++) {
            if(model[i] == null) {
                isFull = false;
                break;
            }
        }
        //jika array penuh, maka resize 2x lipat
        if(isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for(int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        //tambhkan data ke indeks yg nilainya NULL
        for( var i = 0; i < model.length; i++) {
            if(model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh todo ke -  " +i);
        }
        showTodoList();
    }

    public static boolean removeTodoList(Integer number) {
        if((number - 1) >= model.length) {
            return false;
        } else if (model[number -1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        boolean result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String Input(String input) {
        System.out.print(input+ " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = Input("Nama");
        System.out.println("Hi " +name);

    }

    public static void viewShowTodoList() {
        while (true) {
            System.out.println("TODO LIST");
            System.out.println("============");
            showTodoList();
            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");
            var input = Input("pilih");
            if(input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("3")){
               break;
            } else {
                System.out.println("Pilihan invalid");
            }
        }
    }

    public static void testViewShowTodoList() {
        viewShowTodoList();
    }
    //menampilkan view menambahkan TodoList
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODO LIST");
        var todo = Input("Todo (x jika batal)");

        if (todo.equals("x")) {
            //batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodolist() {

        viewAddTodoList();
        showTodoList();
    }
    //menampilkan view menghabpus TodoList
    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODO LIST");
        showTodoList();

        var number = Input("Nomor yang dihapus (x jika batal)");
        if (number.equals("x")) {
            //batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist : " +number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");

        showTodoList();
        viewRemoveTodoList();

        showTodoList();
    }
}
