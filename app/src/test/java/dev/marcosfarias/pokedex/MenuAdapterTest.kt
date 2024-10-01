package dev.marcosfarias.pokedex

import android.content.Context
import dev.marcosfarias.pokedex.model.Menu
import dev.marcosfarias.pokedex.ui.home.MenuAdapter
import io.mockk.mockk
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class MenuAdapterTest {

    private lateinit var adapter: MenuAdapter
    private lateinit var context: Context
    private val menuList = listOf(
        Menu(1, R.string.app_name, R.color.black),
        Menu(2, R.string.app_name, R.color.black)
    )

    @Before
    fun setUp() {
        context = mockk(relaxed = true)
        adapter = MenuAdapter(menuList, context)
    }



    @Test
    fun `getItemCount should return correct item count`() {
        val itemCount = adapter.itemCount
        assertThat(itemCount, equalTo(menuList.size))
    }


}