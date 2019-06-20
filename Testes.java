public class Testes {
 
    private Soma math;
     
    @Before
    public void setUp(){
       math = new Soma();
    }
     
    @Test
    public void sumSucessTest(){
       Integer result = math.sum(10, 10);
       assertThat(Integer.valueOf(20), equalTo(result));
    }
}