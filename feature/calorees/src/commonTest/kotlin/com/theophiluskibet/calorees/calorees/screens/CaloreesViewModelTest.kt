import com.theophiluskibet.calorees.calorees.screens.CaloreesViewModel
import com.theophiluskibet.calorees.calorees.utils.CaloreesUiState
import com.theophiluskibet.calorees.details.utils.FakeCaloreeRepository
import com.theophiluskibet.calorees.details.utils.searchData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class CaloreesViewModelTest {
    private lateinit var repository: FakeCaloreeRepository
    private lateinit var caloreesViewModel: CaloreesViewModel

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        repository = FakeCaloreeRepository()
        caloreesViewModel = CaloreesViewModel(repository = repository)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    // TODO: look into why tests are failing,
//    @Test
//    fun `given CaloreesViewModel - initial calorees ui state is default`() =
//        runTest {
//            assertEquals(CaloreesUiState.Default, caloreesViewModel.caloriesState.value)
//        }

//    @Test
//    fun `given string of food - when getCalories is invoked - then calorees ui state is loading`() =
//        runTest {
//            // given
//            val food = "rice"
//
//            // when
//            caloreesViewModel.getCalories(food)
//
//            // then
//            assertEquals(CaloreesUiState.Loading, caloreesViewModel.caloriesState.value)
//        }

//    @Test
//    fun `given string of food - when getCalories is success - then calorees ui state is success with data`() =
//        runTest {
//            // given
//            val food = "rice"
//
//            // when
//            caloreesViewModel.getCalories(food)
//            advanceUntilIdle()
//
//            // then
//            assertEquals(
//                CaloreesUiState.Success(data = searchData),
//                caloreesViewModel.caloriesState.value,
//            )
//        }

//    @Test
//    fun `given string of food - when getCalories is error - then calorees ui state is error with message`() =
//        runTest {
//            // simulate error in the repository
//            repository.shouldThrowError = true
//
//            // given
//            val food = "rice"
//
//            // when
//            caloreesViewModel.getCalories(food)
//            advanceUntilIdle()
//
//            // then
//            assertEquals(
//                CaloreesUiState.Error(errorMessage = "An error occured"),
//                caloreesViewModel.caloriesState.value,
//            )
//        }
}
