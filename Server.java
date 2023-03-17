import java.io.*;
import java.util.*;
import java.net.*;
import java.util.Stack;




import java.util.LinkedList;


public class Server {
    public static void main(String args[]) {
        try {
            System.out.println("Waiting for client");


            Stack<String> people = new Stack<String>();
            Stack<String> weapon = new Stack<String>();
            Stack<String> room = new Stack<String>();


            people.push("Ms.Pawar");
            people.push("Ms.Pathak");
            people.push("Ms.Patil");
            people.push("Ms.Parmar");


            weapon.push("Wrench");
            weapon.push("lead Pipe");
            weapon.push("Pistol");
            weapon.push("Dagger");
            weapon.push("Candlestick");
            weapon.push("Rope");
            weapon.push("Knife");
            weapon.push("Snipper");


            room.push("Living room");
            room.push("Garage");
            room.push("Office");
            room.push("Bathroom");
            room.push("Kitchen");
            room.push("Dinning room");


            HashMap<Integer, String> room1 = new HashMap<Integer, String>();


            room1.put(1, "Living room");
            room1.put(2, "Garage");
            room1.put(3, "Office");
            room1.put(4, "Bathroom");
            room1.put(5, "Kitchen");
            room1.put(6, "Dinning room");


            Collections.shuffle(people);
            Collections.shuffle(weapon);
            Collections.shuffle(room);


            LinkedList<String> ans = new LinkedList<String>();
            ans.add(people.pop());
            ans.add(weapon.pop());
            ans.add(room.pop());


            Stack<String> deck = new Stack<String>();
            while (!people.isEmpty()) {
                deck.push(people.pop());
            }
            while (!weapon.isEmpty()) {
                deck.push(weapon.pop());
            }
            while (!room.isEmpty()) {
                deck.push(room.pop());
            }


            Collections.shuffle(deck);


            LinkedList<String> player1 = new LinkedList<String>();
            LinkedList<String> player2 = new LinkedList<String>();
            LinkedList<String> player3 = new LinkedList<String>();


            while (!deck.isEmpty()) {
                player1.push(deck.pop());
                player2.push(deck.pop());
                player3.push(deck.pop());
            }


            ServerSocket ss = new ServerSocket(9806);
            Socket s1 = ss.accept();
            Socket s2 = ss.accept();
            Socket s3 = ss.accept();
            System.out.println("Connection established");


            BufferedReader in1 = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            PrintWriter out1 = new PrintWriter(s1.getOutputStream(), true);
            String p1 = in1.readLine();
            out1.println("Hi " + p1);
            out1.println(
                    "Ms.Pawar||Ms.Patil||Ms.Pathak||Ms.Parmar||Wrench||lead Pipe||Pistol||Dagger||Candlestick||Rope||Knife||Snipper||Living room||Garage||Office||Bathroom||Kitchen");


            BufferedReader in2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));
            PrintWriter out2 = new PrintWriter(s2.getOutputStream(), true);
            String p2 = in2.readLine();
            out2.println("Hii " + p2);
            out2.println(
                    "Ms.Pawar||Ms.Patil||Ms.Pathak||Ms.Parmar||Wrench||lead Pipe||Pistol||Dagger||Candlestick||Rope||Knife||Snipper||Living room||Garage||Office||Bathroom||Kitchen");


            BufferedReader in3 = new BufferedReader(new InputStreamReader(s3.getInputStream()));
            PrintWriter out3 = new PrintWriter(s3.getOutputStream(), true);
            String p3 = in3.readLine();
            out3.println("Hiii " + p3);
            out3.println(
                    "Ms.Pawar||Ms.Patil||Ms.Pathak||Ms.Parmar||Wrench||lead Pipe||Pistol||Dagger||Candlestick||Rope||Knife||Snipper||Living room||Garage||Office||Bathroom||Kitchen");


            out1.println(p1 + "  enter something to see your cards");
            String r = in1.readLine();


            for (String s : player1) {
                out1.println(s);
            }


            out2.println(p2 + "  enter something to see your cards");
            r = in2.readLine();
            for (String s : player2) {
                out2.println(s);
            }


            out3.println(p3 + "  enter something to see your cards");
            r = in3.readLine();
            for (String s : player3) {
                out3.println(s);
            }


            do {
                out1.println(p1 + " enter something to proceed");
                r = in1.readLine();
                int flagw = 0;
                int flagm = 0;
                int flagr = 0;
                int iw = 0;
                int im = 0;
                int ir = 0;
                out2.println(p1 + " is playing ");
                out3.println(p1 + " is playing ");
                out1.println(p1 + " enter something to roll a die");
                r = in1.readLine();
                int d = (int) ((Math.random() * 6) + 1);
                String result_room = room1.get(d);


                out1.println(p1 + "you entered room " + result_room + " so your guess will be around this room");


                out1.println(p1 + " Enter a weapon you think might have been used");
                String gweapon1 = in1.readLine();


                out1.println(p1 + " Guess the murderer");
                String gmurder1 = in1.readLine();


                for (String gw1 : player2) {
                    if (gweapon1.equals(gw1)) {
                        flagw = 1;
                        break;
                    }
                    iw++;
                }
                // send flagw


                for (String gm1 : player2) {
                    if (gmurder1.equals(gm1)) {
                        flagm = 1;
                        break;
                    }
                    im++;
                }
                // send flagw


                for (String gr1 : player2) {
                    if (result_room.equals(gr1)) {
                        flagr = 1;
                        break;
                    }
                    ir++;
                }
                // send flagw
                out1.println(flagw);
                out2.println(flagw);
                out3.println(flagw);
                out1.println(flagm);
                out2.println(flagm);
                out3.println(flagm);
                out1.println(flagr);
                out2.println(flagr);
                out3.println(flagr);


                if (flagw == 1 || flagm == 1 || flagr == 1) {
                    out1.println(p2 + "  has the cards....hence your guess is wrong");
                }
                out1.println("Enter something to ask " + p2 + " to show its card");
                r = in1.readLine();
                out1.println("Asking " + p2 + "to reveal the cards");


                if ((flagw == 1 && (flagm == 0 && flagr == 0)) || (flagm == 1 && (flagw == 0 && flagr == 0))
                        || (flagr == 1 && (flagm == 0 && flagw == 0))) {
                    if (flagw == 1) {
                        out1.println(p2 + " has revealed " + player2.get(iw));
                    } else if (flagm == 1) {
                        out1.println(p2 + " has revealed " + player2.get(im));
                    } else if (flagr == 1) {
                        out1.println(p2 + " has revealed " + player2.get(ir));
                    }
                } else if (flagw == 1 && flagm == 1 && flagr == 1) {


                    out2.println("Which card do you wish to show");
                    out2.println(
                            "Enter 0 if you chooses weapon card and 1 if you chooses murderer card and 2 if chooses room card");
                    System.out.println("getting choice ");
                    int ch = Integer.parseInt(in2.readLine());


                    if (ch == 0) {
                        out1.println(p2 + " has revealed " + player2.get(iw));
                    } else if (ch == 1) {
                        out1.println(p2 + " has revealed " + player2.get(im));
                    } else if (ch == 2) {
                        out1.println(p2 + " has revealed " + player2.get(ir));
                    }
                } // 2flags
                else if ((flagw == 1 && flagm == 1 && flagr == 0) || (flagw == 1 && flagr == 1 && flagm == 0)
                        || (flagr == 1 && flagm == 1 && flagw == 0)) {
                    if (flagw == 1 && flagm == 1 && flagr == 0) {// here
                        out2.println("Enter which card you wishes to show : ");
                        out2.println("Enter 0 if you choose weapon card and 1 if you choose murderer card");
                        int ch = Integer.parseInt(in2.readLine());


                        if (ch == 0) {
                            out1.println(p2 + " has revealed " + player2.get(iw));
                        } else if (ch == 1) {
                            out1.println(p2 + " has revealed " + player2.get(im));
                        }
                    } else if (flagw == 1 && flagr == 1 && flagm == 0) {
                        out2.println("Enter which card you wishes to show : ");
                        out2.println("Enter 0 if you choose weapon card and 1 if you choose room card");
                        int ch = Integer.parseInt(in2.readLine());
                        if (ch == 0) {
                            out1.println(p2 + " has revealed " + player2.get(iw));
                        } else if (ch == 1) {
                            out1.println(p2 + " has revealed " + player2.get(ir));
                        }
                    } else if (flagr == 1 && flagm == 1 && flagw == 0) {
                        out2.println("Enter which card you wishe to show : ");
                        out2.println("Enter 0 if he chooses room card and 1 if he chooses murderer card");
                        int ch = Integer.parseInt(in2.readLine());
                        if (ch == 0) {
                            out1.println(p2 + " has revealed " + player2.get(ir));
                        } else if (ch == 1) {
                            out1.println(p2 + " has revealed " + player2.get(im));
                        }
                    }
                } else {// ask player 3
                    out1.println(p2 + " doesn't have the cards hence asking " + p3 + " to reveal the cards");
                    iw = 0;
                    im = 0;
                    ir = 0;
                    flagw = 0;
                    flagm = 0;
                    flagr = 0;


                    for (String gw1 : player3) {
                        if (gweapon1.equals(gw1)) {
                            flagw = 1;
                            break;
                        }
                        iw++;
                    }
                    // send flagw
                    out1.println(flagw);
                    out3.println(flagw);


                    for (String gm1 : player3) {
                        if (gmurder1.equals(gm1)) {
                            flagm = 1;
                            break;
                        }
                        im++;
                    }
                    // send flagw
                    out1.println(flagm);
                    out3.println(flagm);


                    for (String gr1 : player3) {
                        if (result_room.equals(gr1)) {
                            flagr = 1;
                            break;
                        }
                        ir++;
                    }
                    out1.println(flagr);
                    out3.println(flagr);
                    if ((flagw == 1 && (flagm == 0 && flagr == 0)) || (flagm == 1 && (flagw == 0 && flagr == 0))
                            || (flagr == 1 && (flagm == 0 && flagw == 0))) {
                        if (flagw == 1) {
                            out1.println(p3 + " has revealed " + player3.get(iw));
                        } else if (flagm == 1) {
                            out1.println(p3 + " has revealed " + player3.get(im));
                        } else if (flagr == 1) {
                            out1.println(p3 + " has revealed " + player3.get(ir));
                        }
                    } else if (flagw == 1 && flagm == 1 && flagr == 1) {
                        out3.println("Which card do you wish to show");
                        out3.println(
                                "Enter 0 if you chooses weapon card and 1 if you chooses murderer card and 2 if chooses room card");
                        int ch = Integer.parseInt(in3.readLine());


                        if (ch == 0) {
                            out1.println(p3 + " has revealed " + player3.get(iw));
                        } else if (ch == 1) {
                            out1.println(p3 + " has revealed " + player3.get(im));
                        } else if (ch == 2) {
                            out1.println(p3 + " has revealed " + player3.get(ir));
                        }
                    } //
                    else {
                        if (flagw == 1 && flagm == 1 && flagr == 0) {
                            out3.println("Enter which card you wishes to show : ");
                            out3.println("Enter 0 if you choose weapon card and 1 if you choose murderer card");
                            int ch = Integer.parseInt(in3.readLine());


                            if (ch == 0) {
                                out1.println(p3 + " has revealed " + player3.get(iw));
                            } else if (ch == 1) {
                                out1.println(p3 + " has revealed " + player3.get(im));
                            }
                        } else if (flagw == 1 && flagr == 1 && flagm == 0) {
                            out3.println("Enter which card you wishes to show : ");
                            out3.println("Enter 0 if you choose weapon card and 1 if you choose room card");
                            int ch = Integer.parseInt(in3.readLine());
                            if (ch == 0) {
                                out1.println(p3 + " has revealed " + player3.get(iw));
                            } else if (ch == 1) {
                                out1.println(p3 + " has revealed " + player3.get(ir));
                            }
                        } else if (flagr == 1 && flagm == 1 && flagw == 0) {
                            out3.println("Enter which card you wishe to show : ");
                            out3.println("Enter 0 if he chooses room card and 1 if he chooses murderer card");
                            int ch = Integer.parseInt(in3.readLine());
                            if (ch == 0) {
                                out1.println(p3 + " has revealed " + player3.get(ir));
                            } else if (ch == 1) {
                                out1.println(p3 + " has revealed " + player3.get(im));
                            }
                        }
                    }
                }
                if (flagw == 0 && flagr == 0 && flagm == 0) {
                    out1.println("Both players don't have the cards hence, " + p1 + " you win");
                    break;
                }
                // Player 2 rolling
                out2.println(p2 + " enter something to proceed");
                r = in2.readLine();
                flagw = 0;
                flagm = 0;
                flagr = 0;
                iw = 0;
                im = 0;
                ir = 0;


                out1.println(p2 + " is playing ");
                out3.println(p2 + " is playing ");
                out2.println(p2 + " enter something to roll a die");
                r = in2.readLine();
                d = (int) ((Math.random() * 6) + 1);
                result_room = room1.get(d);


                out2.println(p2 + "you entered room " + result_room + " so your guess will be around this room");


                out2.println(p2 + " Enter a weapon you think might have been used");
                String gweapon2 = in2.readLine();


                out2.println(p2 + " Guess the murderer");
                String gmurder2 = in2.readLine();


                for (String gw2 : player3) {
                    if (gweapon2.equals(gw2)) {
                        flagw = 1;
                        break;
                    }
                    iw++;
                }
                // send flagw


                for (String gm2 : player3) {
                    if (gmurder2.equals(gm2)) {
                        flagm = 1;
                        break;
                    }
                    im++;
                }
                // send flagw


                for (String gr2 : player3) {
                    if (result_room.equals(gr2)) {
                        flagr = 1;
                        break;
                    }
                    ir++;
                }
                // send flagw
                out1.println(flagw);
                out2.println(flagw);
                out3.println(flagw);
                out1.println(flagm);
                out2.println(flagm);
                out3.println(flagm);
                out1.println(flagr);
                out2.println(flagr);
                out3.println(flagr);


                if (flagw == 1 || flagm == 1 || flagr == 1) {
                    out2.println(p3 + "  has the cards....hence your guess is wrong");
                }
                out2.println("Enter something to ask " + p3 + " to show its card");
                r = in2.readLine();
                out2.println("Asking " + p3 + "to reveal the cards");


                if ((flagw == 1 && (flagm == 0 && flagr == 0)) || (flagm == 1 && (flagw == 0 && flagr == 0))
                        || (flagr == 1 && (flagm == 0 && flagw == 0))) {
                    if (flagw == 1) {
                        out2.println(p3 + " has revealed " + player3.get(iw));
                    } else if (flagm == 1) {
                        out2.println(p3 + " has revealed " + player3.get(im));
                    } else if (flagr == 1) {
                        out2.println(p3 + " has revealed " + player3.get(ir));
                    }
                } else if (flagw == 1 && flagm == 1 && flagr == 1) {


                    out3.println("Which card do you wish to show");
                    out3.println(
                            "Enter 0 if you chooses weapon card and 1 if you chooses murderer card and 2 if chooses room card");
                    System.out.println("getting choice ");
                    int ch = Integer.parseInt(in3.readLine());


                    if (ch == 0) {
                        out2.println(p3 + " has revealed " + player3.get(iw));
                    } else if (ch == 1) {
                        out2.println(p3 + " has revealed " + player3.get(im));
                    } else if (ch == 2) {
                        out2.println(p3 + " has revealed " + player3.get(ir));
                    }
                } // 2flags
                else if ((flagw == 1 && flagm == 1 && flagr == 0) || (flagw == 1 && flagr == 1 && flagm == 0)
                        || (flagr == 1 && flagm == 1 && flagw == 0)) {
                    if (flagw == 1 && flagm == 1 && flagr == 0) {// here
                        out3.println("Enter which card you wishes to show : ");
                        out3.println("Enter 0 if you choose weapon card and 1 if you choose murderer card");
                        int ch = Integer.parseInt(in3.readLine());


                        if (ch == 0) {
                            out2.println(p3 + " has revealed " + player3.get(iw));
                        } else if (ch == 1) {
                            out2.println(p3 + " has revealed " + player3.get(im));
                        }
                    } else if (flagw == 1 && flagr == 1 && flagm == 0) {
                        out3.println("Enter which card you wishes to show : ");
                        out3.println("Enter 0 if you choose weapon card and 1 if you choose room card");
                        int ch = Integer.parseInt(in3.readLine());
                        if (ch == 0) {
                            out2.println(p3 + " has revealed " + player3.get(iw));
                        } else if (ch == 1) {
                            out2.println(p3 + " has revealed " + player3.get(ir));
                        }
                    } else if (flagr == 1 && flagm == 1 && flagw == 0) {
                        out3.println("Enter which card you wishe to show : ");
                        out3.println("Enter 0 if he chooses room card and 1 if he chooses murderer card");
                        int ch = Integer.parseInt(in3.readLine());
                        if (ch == 0) {
                            out2.println(p3 + " has revealed " + player3.get(ir));
                        } else if (ch == 1) {
                            out2.println(p3 + " has revealed " + player3.get(im));
                        }
                    }
                } else {// ask player 3
                    out2.println(p3 + " doesn't have the cards hence asking " + p1 + " to reveal the cards");
                    iw = 0;
                    im = 0;
                    ir = 0;
                    flagw = 0;
                    flagm = 0;
                    flagr = 0;


                    for (String gw1 : player1) {
                        if (gweapon2.equals(gw1)) {
                            flagw = 1;
                            break;
                        }
                        iw++;
                    }
                    // send flagw
                    out1.println(flagw);
                    out2.println(flagw);


                    for (String gm1 : player1) {
                        if (gmurder2.equals(gm1)) {
                            flagm = 1;
                            break;
                        }
                        im++;
                    }
                    // send flag
                    out1.println(flagm);
                    out2.println(flagm);


                    for (String gr1 : player1) {
                        if (result_room.equals(gr1)) {
                            flagr = 1;
                            break;
                        }
                        ir++;
                    }
                    out1.println(flagr);
                    out2.println(flagr);
                    if ((flagw == 1 && (flagm == 0 && flagr == 0)) || (flagm == 1 && (flagw == 0 && flagr == 0))
                            || (flagr == 1 && (flagm == 0 && flagw == 0))) {
                        if (flagw == 1) {
                            out2.println(p1 + " has revealed " + player1.get(iw));
                        } else if (flagm == 1) {
                            out2.println(p1 + " has revealed " + player1.get(im));
                        } else if (flagr == 1) {
                            out2.println(p1 + " has revealed " + player1.get(ir));
                        }
                    } else if (flagw == 1 && flagm == 1 && flagr == 1) {
                        out1.println("Which card do you wish to show");
                        out1.println(
                                "Enter 0 if you chooses weapon card and 1 if you chooses murderer card and 2 if chooses room card");
                        int ch = Integer.parseInt(in1.readLine());


                        if (ch == 0) {
                            out2.println(p1 + " has revealed " + player1.get(iw));
                        } else if (ch == 1) {
                            out2.println(p1 + " has revealed " + player1.get(im));
                        } else if (ch == 2) {
                            out2.println(p1 + " has revealed " + player1.get(ir));
                        }
                    } //
                    else {
                        if (flagw == 1 && flagm == 1 && flagr == 0) {
                            out1.println("Enter which card you wishes to show : ");
                            out1.println("Enter 0 if you choose weapon card and 1 if you choose murderer card");
                            int ch = Integer.parseInt(in1.readLine());


                            if (ch == 0) {
                                out2.println(p1 + " has revealed " + player1.get(iw));
                            } else if (ch == 1) {
                                out2.println(p1 + " has revealed " + player1.get(im));
                            }
                        } else if (flagw == 1 && flagr == 1 && flagm == 0) {
                            out1.println("Enter which card you wishes to show : ");
                            out1.println("Enter 0 if you choose weapon card and 1 if you choose room card");
                            int ch = Integer.parseInt(in1.readLine());
                            if (ch == 0) {
                                out2.println(p1 + " has revealed " + player1.get(iw));
                            } else if (ch == 1) {
                                out2.println(p1 + " has revealed " + player1.get(ir));
                            }
                        } else if (flagr == 1 && flagm == 1 && flagw == 0) {
                            out1.println("Enter which card you wishe to show : ");
                            out1.println("Enter 0 if he chooses room card and 1 if he chooses murderer card");
                            int ch = Integer.parseInt(in1.readLine());
                            if (ch == 0) {
                                out2.println(p1 + " has revealed " + player1.get(ir));
                            } else if (ch == 1) {
                                out1.println(p1 + " has revealed " + player1.get(im));
                            }
                        }
                    }
                }
                if (flagw == 0 && flagr == 0 && flagm == 0) {
                    out2.println("Both players don't have the cards hence, " + p2 + " you win");
                    break;
                }


                // player 3 rolling
                out3.println(p3 + " enter something to proceed");
                r = in3.readLine();
                flagw = 0;
                flagm = 0;
                flagr = 0;
                iw = 0;
                im = 0;
                ir = 0;


                out2.println(p3 + " is playing ");
                out1.println(p3 + " is playing ");
                out3.println(p3 + " enter something to roll a die");
                r = in3.readLine();
                d = (int) ((Math.random() * 6) + 1);
                result_room = room1.get(d);


                out3.println(p3 + "you entered room " + result_room + " so your guess will be around this room");


                out3.println(p3 + " Enter a weapon you think might have been used");
                String gweapon3 = in3.readLine();


                out3.println(p3 + " Guess the murderer");
                String gmurder3 = in3.readLine();


                for (String gw3 : player1) {
                    if (gweapon3.equals(gw3)) {
                        flagw = 1;
                        break;
                    }
                    iw++;
                }
                // send flagw


                for (String gm3 : player1) {
                    if (gmurder3.equals(gm3)) {
                        flagm = 1;
                        break;
                    }
                    im++;
                }
                // send flagw


                for (String gr3 : player1) {
                    if (result_room.equals(gr3)) {
                        flagr = 1;
                        break;
                    }
                    ir++;
                }
                // send flagw
                out1.println(flagw);
                out2.println(flagw);
                out3.println(flagw);
                out1.println(flagm);
                out2.println(flagm);
                out3.println(flagm);
                out1.println(flagr);
                out2.println(flagr);
                out3.println(flagr);


                if (flagw == 1 || flagm == 1 || flagr == 1) {
                    out3.println(p1 + "  has the cards....hence your guess is wrong");
                }
                out3.println("Enter something to ask " + p1 + " to show its card");
                r = in3.readLine();
                out3.println("Asking " + p1 + " to reveal the cards");


                if ((flagw == 1 && (flagm == 0 && flagr == 0)) || (flagm == 1 && (flagw == 0 && flagr == 0))
                        || (flagr == 1 && (flagm == 0 && flagw == 0))) {
                    if (flagw == 1) {
                        out3.println(p1 + " has revealed " + player1.get(iw));
                    } else if (flagm == 1) {
                        out3.println(p1 + " has revealed " + player1.get(im));
                    } else if (flagr == 1) {
                        out3.println(p1 + " has revealed " + player1.get(ir));
                    }
                } else if (flagw == 1 && flagm == 1 && flagr == 1) {


                    out1.println("Which card do you wish to show");
                    out1.println(
                            "Enter 0 if you chooses weapon card and 1 if you chooses murderer card and 2 if chooses room card");
                    System.out.println("getting choice ");
                    int ch = Integer.parseInt(in1.readLine());


                    if (ch == 0) {
                        out3.println(p1 + " has revealed " + player1.get(iw));
                    } else if (ch == 1) {
                        out3.println(p1 + " has revealed " + player1.get(im));
                    } else if (ch == 2) {
                        out3.println(p1 + " has revealed " + player1.get(ir));
                    }
                } // 2flags
                else if ((flagw == 1 && flagm == 1 && flagr == 0) || (flagw == 1 && flagr == 1 && flagm == 0)
                        || (flagr == 1 && flagm == 1 && flagw == 0)) {
                    if (flagw == 1 && flagm == 1 && flagr == 0) {// here
                        out1.println("Enter which card you wishes to show : ");
                        out1.println("Enter 0 if you choose weapon card and 1 if you choose murderer card");
                        int ch = Integer.parseInt(in1.readLine());


                        if (ch == 0) {
                            out3.println(p1 + " has revealed " + player1.get(iw));
                        } else if (ch == 1) {
                            out3.println(p1 + " has revealed " + player1.get(im));
                        }
                    } else if (flagw == 1 && flagr == 1 && flagm == 0) {
                        out1.println("Enter which card you wishes to show : ");
                        out1.println("Enter 0 if you choose weapon card and 1 if you choose room card");
                        int ch = Integer.parseInt(in1.readLine());
                        if (ch == 0) {
                            out3.println(p1 + " has revealed " + player1.get(iw));
                        } else if (ch == 1) {
                            out3.println(p1 + " has revealed " + player1.get(ir));
                        }
                    } else if (flagr == 1 && flagm == 1 && flagw == 0) {
                        out1.println("Enter which card you wishe to show : ");
                        out1.println("Enter 0 if he chooses room card and 1 if he chooses murderer card");
                        int ch = Integer.parseInt(in1.readLine());
                        if (ch == 0) {
                            out3.println(p1 + " has revealed " + player1.get(ir));
                        } else if (ch == 1) {
                            out3.println(p1 + " has revealed " + player1.get(im));
                        }
                    }
                } else {// ask player 3
                    out3.println(p1 + " doesn't have the cards hence asking " + p2 + " to reveal the cards");
                    iw = 0;
                    im = 0;
                    ir = 0;
                    flagw = 0;
                    flagm = 0;
                    flagr = 0;


                    for (String gw3 : player2) {
                        if (gweapon3.equals(gw3)) {
                            flagw = 1;
                            break;
                        }
                        iw++;
                    }
                    // send flagw
                    out3.println(flagw);
                    out2.println(flagw);


                    for (String gm3 : player2) {
                        if (gmurder3.equals(gm3)) {
                            flagm = 1;
                            break;
                        }
                        im++;
                    }
                    // send flagw
                    out3.println(flagm);
                    out2.println(flagm);


                    for (String gr3 : player2) {
                        if (result_room.equals(gr3)) {
                            flagr = 1;
                            break;
                        }
                        ir++;
                    }
                    out3.println(flagr);
                    out2.println(flagr);
                    if ((flagw == 1 && (flagm == 0 && flagr == 0)) || (flagm == 1 && (flagw == 0 && flagr == 0))
                            || (flagr == 1 && (flagm == 0 && flagw == 0))) {
                        if (flagw == 1) {
                            out3.println(p2 + " has revealed " + player2.get(iw));
                        } else if (flagm == 1) {
                            out3.println(p2 + " has revealed " + player2.get(im));
                        } else if (flagr == 1) {
                            out3.println(p2 + " has revealed " + player2.get(ir));
                        }
                    } else if (flagw == 1 && flagm == 1 && flagr == 1) {
                        out2.println("Which card do you wish to show");
                        out2.println(
                                "Enter 0 if you chooses weapon card and 1 if you chooses murderer card and 2 if chooses room card");
                        int ch = Integer.parseInt(in2.readLine());


                        if (ch == 0) {
                            out3.println(p2 + " has revealed " + player2.get(iw));
                        } else if (ch == 1) {
                            out3.println(p2 + " has revealed " + player2.get(im));
                        } else if (ch == 2) {
                            out3.println(p2 + " has revealed " + player2.get(ir));
                        }
                    } //
                    else {
                        if (flagw == 1 && flagm == 1 && flagr == 0) {
                            out2.println("Enter which card you wishes to show : ");
                            out2.println("Enter 0 if you choose weapon card and 1 if you choose murderer card");
                            int ch = Integer.parseInt(in2.readLine());


                            if (ch == 0) {
                                out3.println(p2 + " has revealed " + player2.get(iw));
                            } else if (ch == 1) {
                                out3.println(p2 + " has revealed " + player2.get(im));
                            }
                        } else if (flagw == 1 && flagr == 1 && flagm == 0) {
                            out2.println("Enter which card you wishes to show : ");
                            out2.println("Enter 0 if you choose weapon card and 1 if you choose room card");
                            int ch = Integer.parseInt(in2.readLine());
                            if (ch == 0) {
                                out3.println(p2 + " has revealed " + player2.get(iw));
                            } else if (ch == 1) {
                                out3.println(p2 + " has revealed " + player2.get(ir));
                            }
                        } else if (flagr == 1 && flagm == 1 && flagw == 0) {
                            out2.println("Enter which card you wishe to show : ");
                            out2.println("Enter 0 if he chooses room card and 1 if he chooses murderer card");
                            int ch = Integer.parseInt(in2.readLine());
                            if (ch == 0) {
                                out3.println(p2 + " has revealed " + player2.get(ir));
                            } else if (ch == 1) {
                                out3.println(p2 + " has revealed " + player2.get(im));
                            }
                        }
                    }
                }
                if (flagw == 0 && flagr == 0 && flagm == 0) {
                    out3.println("Both players don't have the cards hence, " + p3 + " you win");
                    break;
                }


            } while (true);


        } catch (Exception e) {


        }


    }
}



