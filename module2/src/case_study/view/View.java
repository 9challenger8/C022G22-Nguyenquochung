package case_study.view;

import case_study.controllers.FuramaController;

public class View {
    public static void main(String[] args) {
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }
//
    public void delete() {
//        list = File.readMovie();
//        boolean check = false;
//        System.out.println("*---Delete Movie!!!");
//        System.out.println("enter the id want delete");
//        String idDell = sc.nextLine();
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId().equals(idDell)) {
//                check = true;
//                break;
//            }
//        }
//        if (check) {
//            while (check) {
//                System.out.print("you want delete Movie: \n" +
//                        "1.yes"+"\n"+
//                        "2.no\n"+
//                        "you choice : ");
//                int choice = 0;
//                choice = Regex.getChoice(choice);
//                switch (choice){
//                    case 1:
//                        for (int i = 0; i < list.size(); i++) {
//                            if (list.get(i).getId().equals(idDell)) {
//                                list.remove(i);
//                                break;
//                            }
//                        }
//                        System.out.println("***Deleted!!!");
//                        check = false;
//                        break;
//                    case 2:
//                        System.out.println("no");
//                        check = false;
//                        break;
//                    default:
//                        System.out.println("Re- choice: ");
//                }
//            }
//            File.writeMovie(list);
//        }else {
//            System.out.println("dont find id!!!");
//        }
//    }
}
}
