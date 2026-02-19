package com.example.composerlist

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

/**
 * Unit tests for ScreensData - screen configuration and getScreenConfigById.
 */
class ScreensDataTest {

    @Test
    fun getScreenConfigById_returnsCorrectConfig_forValidIds() {
        val config1 = getScreenConfigById(1)
        assertEquals(1, config1?.id)
        assertEquals("Red Screen", config1?.title)
        assertEquals(3, config1?.items?.size)

        val config2 = getScreenConfigById(2)
        assertEquals(2, config2?.id)
        assertEquals("Green Screen", config2?.title)

        val config5 = getScreenConfigById(5)
        assertEquals(5, config5?.id)
        assertEquals("Purple Screen", config5?.title)
    }

    @Test
    fun getScreenConfigById_returnsNull_forInvalidIds() {
        assertNull(getScreenConfigById(0))
        assertNull(getScreenConfigById(6))
        assertNull(getScreenConfigById(-1))
        assertNull(getScreenConfigById(99))
    }

    @Test
    fun screens_hasExactly5Items() {
        assertEquals(5, screens.size)
    }

    @Test
    fun screens_hasCorrectTitles() {
        val expectedTitles = listOf(
            "Red Screen",
            "Green Screen",
            "Blue Screen",
            "Yellow Screen",
            "Purple Screen"
        )
        val actualTitles = screens.map { it.title }
        assertEquals(expectedTitles, actualTitles)
    }

    @Test
    fun eachScreen_has3ListItems() {
        screens.forEach { screen ->
            assertEquals(
                "Screen ${screen.title} should have 3 items",
                3,
                screen.items.size
            )
        }
    }

    @Test
    fun screenIds_areUniqueAndSequential() {
        val ids = screens.map { it.id }
        assertEquals(listOf(1, 2, 3, 4, 5), ids)
    }

    @Test
    fun listItems_haveIconAndName() {
        val redScreen = getScreenConfigById(1)!!
        redScreen.items.forEach { item ->
            assert(item.icon.isNotBlank())
            assert(item.name.isNotBlank())
        }
    }
}
