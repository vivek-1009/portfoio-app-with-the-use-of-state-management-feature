package com.example.vivek9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.vivek9.ui.theme.Vivek9Theme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Vivek9Theme {
                // A surface container using the 'background' color from the theme
                Port()
//statemanagement()

               // myapp()
            }
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Vivek9Theme {
            Greeting("vivek")
        }
    }


//State Management
fun getProjectList():List<Project>{
    return listOf(
        Project(name="vivek",des="I am developer"),
        Project(name="vive",des="I am Game developer"),
        Project(name="viv",des="I am Mobile  developer"),
        Project(name="v",des="I am  busy developer")
    )
}

data class Project(
        var name:String,
        var des:String
        )

@Composable
fun Port() {
    val isOpen=remember{
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight().padding(4.dp),
        shape = RoundedCornerShape(5.dp), tonalElevation = (4.dp)
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally,modifier=Modifier.padding(10.dp)//.background(color=Color.Yellow)) {
        ){
            Image(
                painter = painterResource(id = R.drawable.v),
                contentDescription = null,
                modifier = Modifier.size(19.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Divider()
            Text(
                text = "VIVEK DHINGRA",
                style = TextStyle(
                    color = Color.Green,
                    fontWeight = FontWeight.Bold,
                    fontSize = (20.sp)
                )
                // modifier = Modifier.padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "ANDROID COMPOSABLE DEVELOPER",
                style = TextStyle(
                    color = Color.Green,
                    fontWeight = FontWeight.Bold,
                    fontSize = (10.sp)
                )
                // modifier = Modifier.padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.v),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp)
                )
                Text(
                    text = "2001vivek",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = (10.sp)
                    ),
                    // modifier = Modifier.padding(horizontal = 8.dp)
                    modifier = Modifier.padding(horizontal = 8.dp).size(60.dp)
                )
            }
            Spacer(modifier = Modifier.height(80.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = {isOpen.value=!isOpen.value}, modifier = Modifier.height(80.dp)) {
                    Text(text = "MY PROJECTS")
                }
            }
            if(isOpen.value) {
                LazyColumn {
                    items(getProjectList()) {
                        ProjectItem(it)
                    }
                }
            }
        }
    }
}
@Composable
fun ProjectItem(project:Project){
Row(modifier=Modifier.fillMaxWidth().padding(8.dp)){

    Image(
        painter = painterResource(id = R.drawable.v),
        contentDescription = null,
        modifier = Modifier.size(60.dp).clip(CircleShape)
    )
    Column(modifier=Modifier.padding(horizontal=8.dp)){
       Text(text=project.name,style=MaterialTheme.typography.headlineSmall)
        Text(text=project.des,style=MaterialTheme.typography.headlineLarge)
    }

}
}
