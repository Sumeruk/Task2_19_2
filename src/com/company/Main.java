package com.company;

public class Main {
    public static void main(String[] args) throws Exception {
        
        java.awt.EventQueue.invokeLater(() -> new FrameMain().setVisible(true));


    }

}
































//public static class InputArgs {
//        public String inputFile;
//        public String outputFile;
//        public boolean error;
//        public boolean help;
//        public boolean window;
//    }
//
//
//
//    public static InputArgs parseCmdArgs(String[] args) {
//        InputArgs params = new InputArgs();
//        if (args.length > 0) {
//            if (args[0].equals("--help")) {
//                params.help = true;
//                return params;
//            }
//            if (args[0].equals("--window")) {
//                params.window = true;
//                return params;
//            }
//
//            if (!args[0].equals("-i") && !args[0].equals("--inputfile")
//                    || !args[2].equals("-o") && !args[2].equals("--outputfile") || !args[1].contains(".txt")
//                    || !args[3].contains(".txt")) {
//                params.error = true;
//                params.help = true;
//                return params;
//            }
//
//            if (args.length == 0 || args.length == 4) {
//                params.help = true;
//                params.error = true;
//                return params;
//            }
//
//            if ((args[0].equals("-i") || args[0].equals("--inputfile")) && (args[2].equals("--outputfile") ||
//                    args[2].equals("-o")) && args[1].contains(".txt") && args[3].contains(".txt")) {
//                params.inputFile = "C:\\Users\\12\\IdeaProjects\\Task2_19_2\\" + args[1];
//                params.outputFile = "C:\\Users\\12\\IdeaProjects\\Task2_19_2\\" + args[3];
//                return params;
//            }
//
//        } else {
//            params.help = true;
//            params.error = true;
//        }
//        return params;
//    }
//
//    public static void main(String[] args) throws Exception {
//        InputArgs params = parseCmdArgs(args);
//
//        if (params.help) {
//            PrintStream out = params.error ? System.err : System.out;
//            out.println("Usage:");
//            out.println("  -i input-file -o output-file // ");
//            out.println("  <cmd> --help");
//            out.println("  <cmd> --window  // show window");
//            System.exit(params.error ? 1 : 0);
//        } else {
//            DoublyLinkedList<Integer> linkedlist = WorkWithFile.fileToDoublyLinkedList(params.inputFile);
//            Logic logic = new Logic();
//            logic.changeList(linkedlist, 0);
//            WorkWithFile.doublyLinkedListToFile(params.outputFile, linkedlist);
//        }
//
//    }
//
