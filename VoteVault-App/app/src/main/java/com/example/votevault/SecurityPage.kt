package com.example.votevault

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.votevault.ui.theme.errorColor
import com.example.votevault.ui.theme.primaryColor
import com.example.votevault.ui.theme.surfaceContainer
import com.example.votevault.ui.theme.surfaceLowest
import com.example.votevault.ui.theme.textVariant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecurityPage(modifier: Modifier = Modifier) {

    val vaultGradient = Brush.linearGradient(
        colors = listOf(Color(0xFF001C40), Color(0xFF003067))
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Column(modifier = Modifier.padding(top = 16.dp)) {
            Text(
                text = "Security & Identity",
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold,
                color = primaryColor,
                lineHeight = 40.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Your digital sovereignty is protected by multi-layered biometric encryption and hardware-level isolation.",
                color = textVariant,
                fontSize = 14.sp
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(vaultGradient)
                .padding(24.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("Sovereign ID", color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp)
                        Text("Vishal Kumar", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    }

                    Row(
                        modifier = Modifier
                            .background(Color.White.copy(alpha = 0.1f), RoundedCornerShape(16.dp))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Icon(Icons.Default.Verified, contentDescription = null, tint = Color.White)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("VERIFIED", color = Color.White, fontSize = 10.sp)
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.QrCode2, contentDescription = null, tint = primaryColor)
                    }

                    Text(
                        "8f92..3c1a..d4b0",
                        color = Color.White,
                        fontFamily = FontFamily.Monospace
                    )
                }
            }
        }

        Surface(
            shape = RoundedCornerShape(24.dp),
            color = surfaceLowest,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(24.dp)
            ) {
                Icon(Icons.Default.Fingerprint, contentDescription = null, tint = primaryColor)

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Biometric Identity Verified",
                    fontWeight = FontWeight.Bold,
                    color = primaryColor
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    "Your identity was re-authenticated via hardware-level facial scanning today at 09:41 AM.",
                    color = textVariant,
                    textAlign = TextAlign.Center
                )
            }
        }

        Surface(
            shape = RoundedCornerShape(24.dp),
            color = surfaceContainer,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(24.dp)) {

                Text(
                    "Recent Secure Sessions",
                    fontWeight = FontWeight.Bold,
                    color = primaryColor
                )

                Spacer(modifier = Modifier.height(16.dp))

                SessionItem(
                    icon = Icons.Default.Smartphone,
                    deviceName = "Pixel 7a - VoteVault Mobile",
                    locationInfo = "Prayagraj, UP",
                    statusText = "Active Now",
                    isCurrent = true,
                    primaryColor = primaryColor,
                    errorColor = errorColor
                )

                Spacer(modifier = Modifier.height(12.dp))

                SessionItem(
                    icon = Icons.Default.LaptopMac,
                    deviceName = "MacBook Air M2 - Web Vault",
                    locationInfo = "Gonda, UP",
                    statusText = "Yesterday",
                    isCurrent = false,
                    primaryColor = primaryColor,
                    errorColor = errorColor
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun SessionItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    deviceName: String,
    locationInfo: String,
    statusText: String,
    isCurrent: Boolean,
    primaryColor: Color,
    errorColor: Color
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFEDEEEF)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(icon, contentDescription = null, tint = Color(0xFF56657B))
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(deviceName, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = primaryColor)
                    Text(locationInfo, fontSize = 11.sp, color = Color(0xFF56657B))
                }
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(statusText, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = if (isCurrent) primaryColor else Color.DarkGray)
                Text(
                    if (isCurrent) "CURRENT SESSION" else "EXPIRED",
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF56657B),
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Icon(
                    imageVector = if (isCurrent) Icons.Default.Logout else Icons.Default.Delete,
                    contentDescription = "Action",
                    tint = errorColor,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}