package fgw;

import java.util.InputMismatchException;


public class OrderSystem {
    private Queue<String> inbox = new Queue<>();
    private Queue<String> outbox = new Queue<>();
    private Stack<String> process = new Stack<>();

    private OrderSystem other;

    public Queue<String> getInbox() {
        return inbox;
    }

    public void setInbox(Queue<String> inbox) {
        this.inbox = inbox;
    }

    public Queue<String> getOutbox() {
        return outbox;
    }

    public void setOutbox(Queue<String> outbox) {
        this.outbox = outbox;
    }

    public Stack<String> getProcess() {
        return process;
    }

    public void setProcess(Stack<String> process) {
        this.process = process;
    }

    public OrderSystem getOther() {
        return other;
    }

    public void setOther(OrderSystem other) {
        this.other = other;
    }

    public void connect(OrderSystem orderSystem){
        this.other = orderSystem ;
    }

    public boolean isConnected(){
        if(other == null){
            return false;
        } else
            return true;
    }

    public void disconnect(OrderSystem orderSystem){
        this.other = null;
    }

    public void receive(){
        if(other == null){
            System.out.println("The system is not connected");
        } else {
            System.out.println("Please send message");
        }
    }


    public void sendMessage(){
        try {
            if (!outbox.isEmpty()) {
                while (!outbox.isEmpty()) {
                    other.inbox.offer(outbox.poll());

                }
            } else {
                    System.out.println("Message does not exist");
            }
        } catch (NullPointerException e){
            System.out.println("The system is not connected");
        }

    }

    public void checkMessage(){
    if(process.isEmpty() ){
        System.out.println("Have read all the messages");
    } else {
        String mess = process.pop();
        System.out.println(mess);
    }
    }

    public void ReadInput() {
        try {
                String messValue = inbox.poll().trim();
                if (messValue.length() > 250) {
                    processMessage(messValue);
                } else if (messValue.length() == 0 || messValue == null || messValue == "" || messValue.isEmpty()  ) {
                    throw new Exception("Message is empty! Please enter again!");
                } else {
                    processMessage(messValue);
                    System.out.println("Message : " + messValue);
                    process.push(messValue);

                }

        } catch (InputMismatchException e) {
            System.out.println("Invalid message! Please enter again!");
        } catch (Exception e) {
            System.out.println("Message is empty! Please enter again!");
        }
    }


    public void processMessage(String messValue) { // Dùng để tách message > 250

        try {

            String phanTu1 = messValue.substring(0,250);
            String phanTu2 = messValue.substring(250);
            if(phanTu2.length()<1){
                return;
            }
            String[] splitMess = {phanTu1, phanTu2};
            for (String mess : splitMess) {
                if (mess.length() > 250) {
                    processMessage(mess);
                }
                if (mess.length() == 0 || mess == ""  ) {
                    throw new Exception("Message is empty! Please enter again!");
                }
                if (mess.length() > 0 && mess.length() <= 250) {
                    inbox.offer(mess);



                }
            }
        }catch(InputMismatchException | IllegalArgumentException e) {
            System.out.println("Invalid message! Please enter again!");

        } catch (Exception e) {

        }
    }



}

