package exceptions;


public class IsiException extends RuntimeException {
    public IsiException (String mensagem) {
        super(mensagem);
    }

    public IsiException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
