package tests;

import org.junit.After;
import org.junit.Before;
import utils.Browser;
import utils.Utils;

public class BaseTests{

    //faz o método ser iniciado por primeiro, antes dos testes;
    @Before
    public void setup(){
        Browser.loadPage(Utils.getBaseUrl());//abre o navegador com a URL que está no Utils
    }

    //faz o método ser iniciado por ultimo, depois dos testes;
    @After
    public void tearDown(){
        Browser.print();
        Browser.close();
    }
}
