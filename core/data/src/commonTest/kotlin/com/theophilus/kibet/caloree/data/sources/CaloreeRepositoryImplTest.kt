import com.theophiluskibet.calorees.details.utils.FakeCaloreeRepository
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotNull

class CaloreeRepositoryImplTest {
    private lateinit var repository: FakeCaloreeRepository

    @BeforeTest
    fun setUp() {
        repository = FakeCaloreeRepository()
    }

    @Test
    fun `given a sting of food - when searchcalories is success - returns a list of meals`() =
        runTest {
            val response = repository.searchCalories("meat")
            assertNotNull(response)
        }
}
