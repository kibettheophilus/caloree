import com.theophilus.kibet.caloree.data.sources.CaloreeRepository
import com.theophilus.kibet.caloree.data.sources.CaloreeRepositoryImpl
import com.theophiluskibet.calorees.details.utils.FakeCaloreeRepository
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

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
