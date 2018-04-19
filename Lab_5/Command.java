package com.tasks5.command;

public class Help implements Command {
    @Override
    public void execute() {
        System.out.println("Help executed");
    }
}

package com.tasks5.command;

public class Echo implements Command {

    private String text;

    public Echo(String text){
        this.text = text;
    }
    @Override
    public void execute() {
        System.out.println(text);
    }
}

package com.tasks5.command;

public class Date implements Command{
    @Override
    public void execute() {
        System.out.println(System.currentTimeMillis());
    }
}

package com.tasks5.command;

public class Exit implements Command {
    @Override
    public void execute() {
        System.out.println("Goodbye!");
    }
}

package com.tasks5.command;

public class Application {
    public static void main(String[] args) {
        if(args == null || args.length == 0 || args.length > 2){
            System.out.println("Error");
            return;
        }
        if("help".equals(args[0]) && args.length == 1)
            new Help().execute();
        else if("echo".equals(args[0]) && args.length == 2)
            new Echo(args[1]).execute();
        else if("date".equals(args[0]) &&
                args.length == 2 &&
                "now".equals(args[1]))
            new Date().execute();
        else if("exit".equals(args[0]) && args.length == 1)
            new Exit().execute();
        else
            System.out.println("Error");
    }
}
