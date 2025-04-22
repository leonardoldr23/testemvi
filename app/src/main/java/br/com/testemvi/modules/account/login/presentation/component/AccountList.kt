package br.com.testemvi.modules.account.login.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.testemvi.modules.account.login.data.model.Account

@Composable
fun ColumnScope.AccountList(
    accounts: List<Account>,
    onClick: (Account) -> Unit,
    onDelete: (Account) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .weight(1f)
    ) {
        LazyColumn {
            itemsIndexed(accounts) { index, account ->
                Row {
                    Button(
                        onClick = { onClick.invoke(account) },
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1f),
                        shape = MaterialTheme.shapes.extraSmall,
                    ) {
                        Text(account.email)
                    }
                    Button(
                        onClick = { onDelete.invoke(account) },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Icon(
                            Icons.Filled.Delete,
                            contentDescription = null,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}