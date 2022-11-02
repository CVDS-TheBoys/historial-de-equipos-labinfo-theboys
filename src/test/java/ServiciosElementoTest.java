import com.google.inject.Inject;
import edu.eci.cvds.samples.services.ServiciosElemento;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

public class ServiciosElementoTest {
    @Inject
    private SqlSession sqlSession;
    ServiciosElemento serviciosElemento;

    public ServiciosElementoTest() {
    }

    @Test
    public void test() {
        Assert.assertTrue(true);
    }
}
