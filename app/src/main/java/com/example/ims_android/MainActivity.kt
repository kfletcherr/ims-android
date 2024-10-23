import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.ims_android.R
import com.example.ims_android.ui.theme.ImsandroidTheme

@Composable
fun LoginScreen() {
    // Remember the username and password state
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally // Align content to center horizontally
    ) {
        // Icon
        Image(
            painter = painterResource(id = R.drawable.logo), // Image Reference
            contentDescription = "App Logo",
            modifier = Modifier.size(150.dp) //Image Size
        )

        Spacer(modifier = Modifier.height(24.dp)) // Space between icon and title

        // Title
        Text(
            text = "Inventory Management System",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp)) // Space between title and username field

        // Username Text Field
        TextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp)) // Space between fields

        // Password Text Field
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation() // Mask password

        )

        Spacer(modifier = Modifier.height(24.dp)) // Space before button

        // Login Button
        Button(
            onClick = { /* Handle login click */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp), // Adjust button height if necessary
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)), // Set green color
            shape = RoundedCornerShape(8.dp) // Rounded corners
        ) {
            Text("Log in", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ImsandroidTheme {
        LoginScreen()
    }
}
