package FileUtility;

import bean.Config;
import service.menu.MenuAddStudentService;
import service.menu.MenuLoginService;
import service.menu.MenuRegisterService;
import service.menu.update.MenuService;
import service.menu.MenuAddTeacherService;
import service.menu.MenuShowAllStudentService;
import service.menu.MenuShowAllTeacherSevice;

public enum Menu {
    LOGIN(1, "Login", new MenuLoginService()),
    REGISTER(2, "Register", new MenuRegisterService()),
    ADD_TEACHER(3, "Add Teacher", new MenuAddTeacherService()),
    ADD_STUDENT(4, "Add Student", new MenuAddStudentService()),
    SHOW_ALL_TEACHER(5, "Show all teachers", new MenuShowAllTeacherSevice()),
    SHOW_ALL_STUDENT(6, "Show all students", new MenuShowAllStudentService()),
    UNKNOWN;

    private int number;
    private String label;
    MenuService service;

    Menu() {

    }

    Menu(int number, String label, MenuService service) {
        this.number = number;
        this.label = label;
        this.service = service;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return number + ". " + label;
    }

    public void process2() {
        service.process1();
        MenuUtil.showMenu();
        
    }

    public int getNumber() {
        return this.number;
    }

    public static Menu find(int number) {
        Menu[] menus = Menu.values();
        for (Menu menu : menus) {
            if (menu.getNumber() == number) {
                return menu;
            }
        }
        return Menu.UNKNOWN;
    }

    public static void showAllMenu() {
        Menu[] menus = Menu.values();

        for (int i = 0; i < menus.length; i++) {
            if (menus[i] != UNKNOWN) {
                if (menus[i] == LOGIN || menus[i] == REGISTER) {
                    if (!Config.isLogged_in()) {
                        System.out.println(menus[i]);
                    }
                } else if (Config.isLogged_in()) { //true
                    System.out.println(menus[i]);
                }
            }
        }
    }

}
