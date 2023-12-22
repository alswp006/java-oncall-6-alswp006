package oncall.view.validator;

public abstract class Validator {
    private final String ERROR_HEAD = "[ERROR]" ;

    protected void throwError(String errorMessage){
        System.out.println(ERROR_HEAD + errorMessage);
        throw new IllegalArgumentException();
    }

    public abstract void validate(String input);
}