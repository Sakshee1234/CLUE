import java.net.*;
import java.io.*;


public class Player2 {
    public static void main(String[] args) {
        try {
            System.out.println("PLayer 2 landed");
            Socket soc2 = new Socket("localhost", 9806);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your name : ");
            String str = userInput.readLine();
            PrintWriter out = new PrintWriter(soc2.getOutputStream(), true);
            out.println(str);
            BufferedReader in = new BufferedReader(new InputStreamReader(soc2.getInputStream()));
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            //
            System.out.println(in.readLine());
            String r = userInput.readLine();
            out.println(r);
            // 5cards
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println(in.readLine());


            do {
                System.out.println(in.readLine());


                int flagw = Integer.parseInt(in.readLine());
                int flagm = Integer.parseInt(in.readLine());
                int flagr = Integer.parseInt(in.readLine());
                if (flagm == 1 || flagw == 1 || flagr == 1) {


                    if (flagw == 1 && flagm == 1 && flagr == 1) {
                        System.out.println(in.readLine());
                        System.out.println(in.readLine());
                        int ch = Integer.parseInt(userInput.readLine());
                        out.println(ch);
                    } else if ((flagw == 1 && flagm == 1 && flagr == 0) || (flagw == 1 && flagr == 1 && flagm == 0)
                            || (flagr == 1 && flagm == 1 && flagw == 0)) {


                        if (flagw == 1 && flagm == 1 && flagr == 0) {
                            System.out.println(in.readLine());
                            System.out.println(in.readLine());
                            int ch = Integer.parseInt(userInput.readLine());
                            out.println(ch);
                        } else if (flagw == 1 && flagr == 1 && flagm == 0) {
                            System.out.println(in.readLine());
                            System.out.println(in.readLine());
                            int ch = Integer.parseInt(userInput.readLine());
                            out.println(ch);


                        } else {
                            System.out.println(in.readLine());
                            System.out.println(in.readLine());
                            int ch = Integer.parseInt(userInput.readLine());
                            out.println(ch);
                        }
                    }
                }
                // you are playing
                System.out.println(in.readLine());
                r = userInput.readLine();
                out.println(r);
                // to roll die
                System.out.println(in.readLine());
                r = userInput.readLine();
                out.println(r);
                // entering room
                System.out.println(in.readLine());
                // weapon guess
                System.out.println(in.readLine());
                String gweapon1 = userInput.readLine();
                out.println(gweapon1);
                // murderer guess
                System.out.println(in.readLine());
                String gmurder1 = userInput.readLine();
                out.println(gmurder1);


                flagw = Integer.parseInt(in.readLine());
                flagm = Integer.parseInt(in.readLine());
                flagr = Integer.parseInt(in.readLine());


                if (flagw == 1 || flagm == 1 || flagr == 1) {


                    System.out.println(in.readLine());
                }
                // to proceed
                System.out.println(in.readLine());
                r = userInput.readLine();
                out.println(r);
                System.out.println(in.readLine());
                // one flag 1
                if ((flagw == 1 && (flagm == 0 && flagr == 0)) || (flagm == 1 && (flagw == 0 && flagr == 0))
                        || (flagr == 1 && (flagm == 0 && flagw == 0))) {
                    if (flagw == 1) {
                        System.out.println(in.readLine());
                    } else if (flagr == 1) {
                        System.out.println(in.readLine());
                    } else {
                        System.out.println(in.readLine());
                    }
                } else if (flagw == 1 && flagm == 1 && flagr == 1) {


                    System.out.println(in.readLine());
                } // 2 flags
                else if ((flagw == 1 && flagm == 1 && flagr == 0) || (flagw == 1 && flagr == 1 && flagm == 0)
                        || (flagr == 1 && flagm == 1 && flagw == 0)) {
                    if (flagw == 1 && flagm == 1 && flagr == 0) {
                        // System.out.println(in.readLine());
                        // System.out.println(in.readLine());
                        // int ch = Integer.parseInt(in.readLine());
                        // cards


                        System.out.println(in.readLine());
                        // if (ch == 0) {
                        // System.out.println(in.readLine());
                        // } else if (ch == 1) {
                        // System.out.println(in.readLine());
                        // }
                    } else if (flagw == 1 && flagr == 1 && flagm == 0) {
                        // System.out.println(in.readLine());
                        // System.out.println(in.readLine());
                        // int ch = Integer.parseInt(in.readLine());
                        System.out.println(in.readLine());
                        // if (ch == 0) {
                        // System.out.println(in.readLine());
                        // } else if (ch == 1) {
                        // System.out.println(in.readLine());
                        // }
                    } else if (flagr == 1 && flagm == 1 && flagw == 0) {
                        System.out.println(in.readLine());


                    }
                } else if (flagw == 0 && flagr == 0 && flagm == 0) {// all flag 0 ask player 3
                    System.out.println(in.readLine());
                    flagw = Integer.parseInt(in.readLine());
                    flagm = Integer.parseInt(in.readLine());
                    flagr = Integer.parseInt(in.readLine());


                    // to proceed
                    // one flag 1
                    if ((flagw == 1 && (flagm == 0 && flagr == 0)) || (flagm == 1 && (flagw == 0 && flagr == 0))
                            || (flagr == 1 && (flagm == 0 && flagw == 0))) {
                        if (flagw == 1) {
                            System.out.println(in.readLine());
                        } else if (flagr == 1) {
                            System.out.println(in.readLine());
                        } else {
                            System.out.println(in.readLine());
                        }
                    } else if (flagw == 1 && flagm == 1 && flagr == 1) {
                        System.out.println(in.readLine());
                        System.out.println(in.readLine());


                    } // 2 flags
                    else if ((flagw == 1 && flagm == 1 && flagr == 0) || (flagw == 1 && flagr == 1 && flagm == 0)
                            || (flagr == 1 && flagm == 1 && flagw == 0)) {
                        if (flagw == 1 && flagm == 1 && flagr == 0) {
                            System.out.println(in.readLine());
                        } else if (flagw == 1 && flagr == 1 && flagm == 0) {
                            System.out.println(in.readLine());


                        } else if (flagr == 1 && flagm == 1 && flagw == 0) {
                            System.out.println(in.readLine());


                        }
                    }
                }
                if (flagw == 0 && flagr == 0 && flagm == 0) {
                    System.out.println(in.readLine());
                    break;
                }


                System.out.println(in.readLine());
                flagw = Integer.parseInt(in.readLine());
                flagm = Integer.parseInt(in.readLine());
                flagr = Integer.parseInt(in.readLine());
                if (flagw == 0 && flagm == 0 && flagr == 0) {
                    flagw = Integer.parseInt(in.readLine());
                    flagm = Integer.parseInt(in.readLine());
                    flagr = Integer.parseInt(in.readLine());
                    if (flagw == 1 && flagm == 1 && flagr == 1) {
                        System.out.println(in.readLine());
                        System.out.println(in.readLine());
                        int ch = Integer.parseInt(userInput.readLine());
                        out.println(ch);
                    } else if ((flagw == 1 && flagm == 1 && flagr == 0) || (flagw == 1 && flagr == 1 && flagm == 0)
                            || (flagr == 1 && flagm == 1 && flagw == 0)) {


                        if (flagw == 1 && flagm == 1 && flagr == 0) {
                            System.out.println(in.readLine());
                            System.out.println(in.readLine());
                            int ch = Integer.parseInt(userInput.readLine());
                            out.println(ch);
                        } else if (flagw == 1 && flagr == 1 && flagm == 0) {
                            System.out.println(in.readLine());
                            System.out.println(in.readLine());
                            int ch = Integer.parseInt(userInput.readLine());
                            out.println(ch);


                        } else {
                            System.out.println(in.readLine());
                            System.out.println(in.readLine());
                            int ch = Integer.parseInt(userInput.readLine());
                            out.println(ch);
                        }
                    }
                }


            } while (true);
        }


        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// choice wen 3 cards



