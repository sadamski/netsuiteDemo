package com.adamtrcka.work.hw.args;

//entire java file dedicated to seeing if arg passed to program can be fetched, before any JSON parsing is used
public class ArgumentValidator {

    private String[] args;
    private String validatedArgument;

    //REQ-002 simple argument data validation, TODO will crash if file not found
    public ArgumentValidator(String[] args) {                                       //some random comment to see if javadoc is working or not
        this.args = args;
    }

    public boolean isValid() {

        try {                                                                       //basic file IO examples, try import a file, else fail
            if (!this.args[0].equals("")) {                                         //as long is args is not empty... do something
                this.validatedArgument = this.args[0];
                System.out.println("filename is defined:" + this.getArgument());
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Specify json filename as arg0");                    //REQ-001, REQ-002 if nothing is passed as args, file fetch failes
        }

        return false;
    }

    //for some simple unit testing
    public String getArgument()                                                     //more javadoc experiemnts
    {
        return this.validatedArgument;
    }


}
