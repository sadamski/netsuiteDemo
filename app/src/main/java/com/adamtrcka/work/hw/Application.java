package com.adamtrcka.work.hw;

import com.adamtrcka.work.hw.args.ArgumentValidator;
import com.adamtrcka.work.hw.json.jsonReader;

public class Application {

    //Start of main application
    public Application(String[] args) {

        //takes the input args, and passes it into the ArgumentValidator method
        ArgumentValidator arg = new ArgumentValidator(args);
        if (arg.isValid()) {
            this.process(arg.getArgument());
        }
    }

    private void process(String fileName) {
        jsonReader json = new jsonReader(fileName);
    }

}
