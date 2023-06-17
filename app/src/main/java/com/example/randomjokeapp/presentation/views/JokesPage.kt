import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomjokeapp.presentation.viewModel.JokesViewModel

@Composable
fun JokesPage(viewModel: JokesViewModel) {
    val joke by viewModel.joke.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            color = Color.White,
//            elevation = 4.dp
        ) {
            Card(Modifier.padding(16.dp)) {
                Column(Modifier.padding(16.dp)) {
                    Button(
                        onClick = { viewModel.fetchJoke() },
                        modifier = Modifier.fillMaxWidth()
                            .padding(bottom = 10.dp)
                    ) {
                        Text(text = "New Joke")
                    }
                    Row() {
                        Text(
                            text = "Joke SetUp : ",
                            fontWeight = FontWeight.Bold,
                            color = Color.Blue
                        )
                        Text(text = joke.setup)
                    }
                    Row() {
                        Text(
                            text = "Joke PunchLine : ",
                            fontWeight = FontWeight.Bold,
                            color = Color.Blue
                        )
                        Text(text = joke.punchline)
                    }
                }
            }
        }
    }
}
