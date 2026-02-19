package com.example.composerlist

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

/**
 * Unit tests for MainViewModel – verifies that it exposes the same data
 * as the underlying ScreensData and correctly looks up screen configs by ID.
 */
class MainViewModelTest {

    private val viewModel = MainViewModel()

    @Test
    fun screenConfigs_exposesAllScreens_fromScreensData() {
        val viewModelScreens = viewModel.screenConfigs.value

        // Same size as the top-level screens list
        assertEquals(screens.size, viewModelScreens.size)

        // Same titles in the same order
        val expectedTitles = screens.map { it.title }
        val actualTitles = viewModelScreens.map { it.title }
        assertEquals(expectedTitles, actualTitles)
    }

    @Test
    fun getScreenConfigById_returnsCorrectConfig_forValidIds() {
        val config1 = viewModel.getScreenConfigById(1)
        assertEquals(1, config1?.id)
        assertEquals("Red Screen", config1?.title)
        assertEquals(3, config1?.items?.size)

        val config3 = viewModel.getScreenConfigById(3)
        assertEquals(3, config3?.id)
        assertEquals("Blue Screen", config3?.title)

        val config5 = viewModel.getScreenConfigById(5)
        assertEquals(5, config5?.id)
        assertEquals("Purple Screen", config5?.title)
    }

    @Test
    fun getScreenConfigById_returnsNull_forInvalidIds() {
        assertNull(viewModel.getScreenConfigById(0))
        assertNull(viewModel.getScreenConfigById(6))
        assertNull(viewModel.getScreenConfigById(-1))
        assertNull(viewModel.getScreenConfigById(99))
    }
}

