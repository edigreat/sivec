package integration.repositorio;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	UsuarioDaoIntegrationTestCase.class,
	ReparacionEquipoDaoIntegrationTestCase.class,
	MenuRolDaoIntegrationTestCase.class,
	EquipoComputoDaoIntegrationTestCase.class,
	DependenciaUniDaoTestCase.class,
	MenuItemDaoIntegrationTestCase.class
	})
public class RepositorioTestSuit {

}
