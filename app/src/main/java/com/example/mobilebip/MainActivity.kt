package com.example.mobilebip

import android.os.Bundle
import android.Manifest
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mobilebip.model.Op
import com.example.mobilebip.model.hasResource
import com.example.mobilebip.ui.theme.MobileBipTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
@ExperimentalPermissionsApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileBipTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Body()
                }
            }
        }
    }
}
@ExperimentalPermissionsApi
@Composable
fun Body() {
    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)

    if (cameraPermissionState.status.isGranted) {
        CameraScreen()
    }
    else if (cameraPermissionState.status.shouldShowRationale) {
        Text("Permissão de câmera negada.")
    }
    else {
        SideEffect {
            cameraPermissionState.run { launchPermissionRequest() }
        }
        Text("Sem permissão de câmera.")
    }
//    val context = LocalContext.current
//    var resource by remember { mutableStateOf("") }
//    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .padding(horizontal = Dp(2.0f), vertical = Dp(2.0f))
//            .fillMaxSize()
//        ) {
//        TextField(
//            value = resource,
//            onValueChange = {
//                if (hasResource(resource) == 1) {
//                    resource = it
//                } else {
//                    Toast.makeText(context, "Recurso não encontrado", Toast.LENGTH_LONG).show()
//                } },
//            shape = MaterialTheme.shapes.large,
//            label = { Text(text = "Recurso") }
//        )
//        TableWidget()
//    }
}

@Composable
fun TableWidget() {
    val newOps = remember { mutableStateListOf<Op>() }
    val titleWeight = 5f
    val opWeight = 7f
    val prodWeight = 3f
    LazyColumn {
        item {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                TableTitle(text = "Ordem de Produção", weight = titleWeight)
                TableTitle(text = "Produto", weight = titleWeight)
            }
        }
        items(newOps) {
            for (newOp in newOps.indices) {
                Row(Modifier.fillMaxWidth()) {
                    TableCell(value = newOps[newOp].code, weight = opWeight)
                    TableCell(value = newOps[newOp].prod, weight = prodWeight)
                }
            }

        }
    }
}

@Composable
fun RowScope.TableTitle(text : String, weight: Float) {
    Text(
        text = text,
        modifier = Modifier.weight(weight)
    )
}

@Composable
fun RowScope.TableCell(value : String, weight : Float) {
    TextField(
        value = value,
        onValueChange = {
        },
        modifier = Modifier
            .border(1.dp, Color.Black)
            .weight(weight)
            .padding(8.dp)
    )
}
@ExperimentalPermissionsApi
@Preview
@Composable
fun BodyPreview() {
    MobileBipTheme {
        Surface( modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        )  {
            Body()
        }
    }
}