import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.votevault.BallotPage
import com.example.votevault.ProfilePage
import com.example.votevault.ResultsPage
import com.example.votevault.SecurityPage
import com.example.votevault.ui.theme.primaryColor
import com.example.votevault.ui.theme.surfaceColor
import com.example.votevault.ui.theme.textVariant

data class VaultNavItem(val label: String, val icon: ImageVector)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val navItems = listOf(
        VaultNavItem("Ballot", Icons.Default.HowToVote),
        VaultNavItem("Security", Icons.Default.VerifiedUser),
        VaultNavItem("Results", Icons.Default.Analytics),
        VaultNavItem("Profile", Icons.Default.AccountCircle)
    )

    var selectedIndex by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        containerColor = surfaceColor,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(surfaceColor.copy(alpha = 0.9f))
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .systemBarsPadding(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Security, contentDescription = "Shield", tint = primaryColor)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("VoteVault", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Notifications, contentDescription = "Alerts", tint = textVariant, modifier = Modifier.size(28.dp))
                    Spacer(modifier = Modifier.width(16.dp))
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    ) {
                        Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.align(Alignment.Center), tint = Color.Gray)
                    }
                }
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = surfaceColor.copy(alpha = 0.9f),
                tonalElevation = 8.dp
            ) {
                navItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            selectedTextColor = primaryColor,
                            indicatorColor = primaryColor
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        val pageModifier = Modifier.padding(innerPadding)

        when (selectedIndex) {
            0 -> BallotPage(pageModifier)
            1 -> SecurityPage(pageModifier)
            2 -> ResultsPage(pageModifier)
            3 -> ProfilePage(pageModifier)
        }
    }
}