package fgw;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        OrderSystem systemA = new OrderSystem();
        OrderSystem systemB = new OrderSystem();
        systemA.getOutbox().offer("Hello");
        systemA.getOutbox().offer("Hi");
        systemA.getOutbox().offer("Hu");
        systemA.getOutbox().offer("Trong những ngày đầu của năm mới, chúng ta thường tìm kiếm sự đổi mới và cơ hội mới. Năm nay, hãy nhìn nhận những thách thức như những cơ hội để phát triển và học hỏi. Hãy dũng cảm đối mặt với những điều mới mẻ và khám phá khả năng tiềm ẩn của bản thân. Cuộc sống luôn đưa ra những bài học quý giá, và chúng ta có thể trở nên mạnh mẽ hơn thông qua mỗi trải nghiệm. Đôi khi, hành trình mới có thể đầy khó khăn, nhưng nhớ rằng bản thân bạn có sức mạnh để vượt qua mọi thách thức. Hãy đặt ra những mục tiêu lớn và tập trung vào những bước nhỏ để đạt được chúng. Sự kiên trì và nỗ lực không ngừng sẽ giúp bạn vượt qua mọi chướng ngại và đạt được thành công.Trong cuộc sống, đừng quên giữ lại thời gian cho bản thân và những người thân yêu. Hãy tận hưởng những khoảnh khắc đơn giản, và đề cao những mối quan hệ quan trọng nhất trong cuộc đời.Chúc bạn một năm mới tràn đầy năng lượng tích cực, sức khỏe dồi dào và thành công trong mọi lĩnh vực. Hãy tận hưởng hành trình phía trước và biến mọi giấc mơ thành hiện thực.");

        Scanner sc = new Scanner(System.in);
        long startTime = System.nanoTime();
        boolean exitmenu = false;
        while (!exitmenu) {
                System.out.println("==========================Menu==========================");
                System.out.println("1. Connect system\n" +
                        "2. SystemA\n" +
                        "3. SystemB\n" +
                        "4. isConnected\n" +
                        "5. Disconnect\n" +
                        "6. Exit\n");
                int a = Integer.parseInt(sc.nextLine());
                switch (a) {
                    case 1:
                        systemB.connect(systemA);
                        systemA.connect(systemB);
                        System.out.println("The system is connected ");
                        break;
                    case 2:
                        boolean exitA = false;
                        while (!exitA) {
                            System.out.println("==========================SystemA==========================");
                            System.out.println("1. Input message\n" +
                                    "2. Send message\n" +
                                    "3. Exit\n");
                            int b = Integer.parseInt(sc.nextLine());
                            switch (b) {
                                case 1:
                                    System.out.println("Please input message");
                                    String message = sc.nextLine();
                                    systemA.getOutbox().offer(message);
                                    System.out.println(systemA.getOutbox());
                                    break;
                                case 2:
                                    systemA.sendMessage();
                                    System.out.print("Message has been sent");
                                    System.out.println("Messages are being processed in the inbox: " + systemB.getInbox());
                                    break;
                                case 3:
                                    exitA = true;
                                    break;
                                default:
                                    System.out.println("Your selection is not valid");
                                    break;
                            }
                        }
                        break;
                    case 3:

                        boolean exitB = false;
                        while (!exitB) {
                            System.out.println("==========================SystemB==========================");
                            System.out.println("1. Request to send message\n" +
                                    "2. Read message\n" +
                                    "3. Check inbox\n" +
                                    "4. Checkmessage\n" +
                                    "5. Exit\n");
                            int c = Integer.parseInt(sc.nextLine());
                            switch (c) {
                                case 1:
                                    systemB.receive();
                                    break;
                                case 2:
                                    systemB.ReadInput();
                                    break;
                                case 3:
                                    System.out.println("Inbox: " + systemB.getInbox());
                                    break;
                                case 4:
                                    System.out.println(systemB.getProcess());
                                    systemB.checkMessage();
                                    break;
                                case 5:
                                    exitB = true;
                                    break;
                                default:
                                    System.out.println("Your selection is not valid");
                                    break;
                            }
                        }
                        break;
                    case 4:
                        System.out.println(systemA.isConnected());
                        break;
                    case 5:
                        systemA.disconnect(systemB);
                        systemB.disconnect(systemA);
                        System.out.println("The system is disconnected");
                        break;
                    case 6:
                        System.out.println("Exit program");
                        System.out.println();
                        exitmenu = true;
                        break;
                    default:
                        System.out.println("Your selection is not valid");
                        break;
                }
            }
            long endTime = System.nanoTime();
            long time = endTime - startTime;
            System.out.println("The time to execute the program: " + time + " nanoseconds");
            System.out.println("The time to execute the program: " + time / 1000000000.0 + " seconds");



    }

}
