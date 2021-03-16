package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.*;

@Feature("Teste site de ecommerce")

public class SetupTest extends BaseTests{

    //Teste abrir o site
    @Test
    @Story("Abrir o site")
    public void testOpeningBrowserAndLoadingPage(){
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
            System.out.println("Abrimos o navegador e carregamos a URL!");
    }

    //Teste de login
    @Test
    @Story("Realizar o login")
    public void testLogin(){
            Browser.getCurrentDriver().findElement(By.className("login")).click();//buscou o elemento dentro do site;
            System.out.println("Click em Sing In e direcionou para a página de login");
            Assert.assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("/index.php?controller=authentication&back=my-account")));
            Browser.getCurrentDriver().findElement(By.id("email")).sendKeys("rrsetcwi+autopractice@gmail.com");
            System.out.println("\nPreencheu email");
            Browser.getCurrentDriver().findElement(By.id("passwd")).sendKeys("teste123");
            System.out.println("\nPreencheu senha");
            Browser.getCurrentDriver().findElement(By.id("SubmitLogin")).click();
            System.out.println("\nClicou em Sign In");
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
            System.out.println("\nValidou a url de minha conta");
            assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
            System.out.println("\nValidou Minha Conta no site");

    }

    //Teste para pesquisar um produto
    @Test
    public void testSearch(){

        String quest = "DRESS";
        String questResultQtd = "7 results have been found";

        //iniciar as páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();

        //Fazer a pesquisa
        home.doSearch(quest);

        //Validar a pesquisa
        assertTrue(search.isSearchPage());
        assertEquals(search.getTextLighter().replace("\"", ""),quest);
        assertThat(search.getTextHeading_counter(), CoreMatchers.containsString(questResultQtd));
    }

    //Teste para adicionar um produto ao carrinho
    @Test
    public void testCart(){
        String pesquisa = "Faded Short Sleeve T-shirts";
        String questResultQtd = "1 result has been found.";
        String validarPagina = "Send to a friend";
        String addCartOk = "Proceed to checkout";

        //abrir a página
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();
        System.out.println("\nAbriu a página");

        //pesquisar produto
        home.doSearch(pesquisa);
        System.out.println("\nPesquisou o produto");
        assertTrue(search.isSearchPage());
        assertThat(search.getTextHeading_counter(), CoreMatchers.containsString(questResultQtd));
        System.out.println("\nValidou a pesquisa");

        //abrir página do produto
        search.linkProduct();
        System.out.println("\nClicou no link do produto");
        assertThat(search.getSend_friend_button(), CoreMatchers.containsString(validarPagina));
        System.out.println("\nAbriu página do produto");

        //adicionar ao carrinho
        search.add_to_cart();
        System.out.println("\nClicou em Add to Cart");
        assertThat(search.getCartOk(), CoreMatchers.containsString(addCartOk));
        System.out.println("\nAdicionou ao carrinho");

    }

    //Implementando os testes
    @Test
    @Story("Acessar categoria")
    public void testAcessCategoryTShirts(){
        //Iniciar as páginas
        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();

        //Clicar na categoria T-SHIRTS
        home.clickCategoryTShirts();

        //Validar se ao clicar na categoria T_SHIRTS ocorre o direcionamento correto
        assertTrue(category.isPageTShirts());
    }

    //Add produto para a página de produto
    @Test
    @Story("Acessar página de produto")
    public void testeAddProdutoToProductPage(){
        //Acessar a categoria T-Shirts
        testAcessCategoryTShirts();

        //Iniciar as páginas
        CategoryPage category = new CategoryPage();
        ProductPage pdp = new ProductPage();

        //Salva nome do produto na página de categoria
        String nameProductCategory = category.getProductNameCategory();

        //Clicar em More e direcionar para a página do produto
        category.clickProductAddTpProductPage();

        //Verificar se o produto está na página de detalhes do produto corretamente
        assertTrue(pdp.getProductNamePDP().equals(nameProductCategory));

    }

    @Test
    @Story("Adiciona produto ao carrinho")
    public void testAddProductToCartPage(){
        //Acessar a página de produto
        testeAddProdutoToProductPage();

        //Iniciar as páginas
        ProductPage pdp = new ProductPage();
        CartPage cart = new CartPage();

        //Salvar o nome do produto na página de PDP;
        String nameProductPDP = pdp.getProductNamePDP();

        //Clicar no botão de Acicionar ao carrinho
        pdp.clickButtonAddToCart();

        //Clicar no botão Proceed to Checkout
        pdp.clickButtonModalProceedToCheckout();

        //validação do nome do produto no carrinho
        assertTrue(cart.getNameProductCart().equals(nameProductPDP));
    }

    //Teste fluxo de criação de conta
    @Test
    public void testLoginPage(){
        //Inicia a página
        HomePage home = new HomePage();
        LoginPage loginPage = new LoginPage();

        //Clicar em Sign in
        home.clickBtnLogin();

        //Valida página de login
        assertTrue(loginPage.isPageLogin());
        //Adicionar e-mail no campo Create An Account
        loginPage.enterEmailCreate();

        //Clicar no botão Create An Account
        loginPage.clickBtnCreateAccount();

    }

    @Story("Fluxo de criação de conta")
    @Test
    public void testCreateAccount() {
        testLoginPage();
        CreateAccountPage account = new CreateAccountPage();

        //Seleciona o gênero
        account.selectGender();

        //Digita primeiro e último nome
        account.enterFirstName();
        account.enterLastName();

        //Digitou a senha
        account.enterPassWord();

        //Seleciona o dia do aniversário
        account.selectDayOfBirth();
        //Seleciona o mês do aniversário
        account.selectMonthOfBirth();
        //Seleciona o ano do aniversário
        account.selectYearOfBirth();

        //Digitia primeiro nome do endereço
        account.enterFirstNameAdress();
        //Digitia último nome do endereço
        account.enterLastNameAdress();
        //Digitia empresa do endereço
        account.enterCompanyName();
        //Digita endereço
        account.enterAddress();
        //Digita o complemento do endereço
        account.enterAddressComplement();
        //Digita a cidade
        account.enterCity();
        //Seleciona o estado
        account.selectState();
        //Digita o CEP
        account.enterPostalCode();
        //Seleciona o país
        account.selectCountry();

        //Digita o telefone
        account.enterMobilePhone();

        //Digita assinatura do endereço
        account.enterAssignAddress();

        //Clica em Register
        account.clickRegister();

        //Valida Conta
        assertTrue(account.isMyAccount());
    }
}
