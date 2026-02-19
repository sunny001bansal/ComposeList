package com.example.composerlist

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * UI tests for the ComposerList app - HomeScreen and DetailScreen navigation.
 */
@RunWith(AndroidJUnit4::class)
class ComposerListUiTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun homeScreen_displaysMainScreenTitle() {
        composeTestRule.onNodeWithText("Main Screen").assertIsDisplayed()
    }

    @Test
    fun homeScreen_displaysAllFiveScreenCards() {
        composeTestRule.onNodeWithTag("screen_card_1").assertIsDisplayed()
        composeTestRule.onNodeWithTag("screen_card_2").assertIsDisplayed()
        composeTestRule.onNodeWithTag("screen_card_3").assertIsDisplayed()
        composeTestRule.onNodeWithTag("screen_card_4").assertIsDisplayed()
        composeTestRule.onNodeWithTag("screen_card_5").assertIsDisplayed()
    }

    @Test
    fun homeScreen_displaysScreenTitles() {
        composeTestRule.onNodeWithText("Red Screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Green Screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Blue Screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Yellow Screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Purple Screen").assertIsDisplayed()
    }

    @Test
    fun tappingRedScreen_navigatesToDetailAndShowsRedContent() {
        composeTestRule.onNodeWithTag("screen_card_1").performClick()

        composeTestRule.onNodeWithText("Red Screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Items in Red Screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Red Item 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Red Item 2").assertIsDisplayed()
        composeTestRule.onNodeWithText("Red Item 3").assertIsDisplayed()
    }

    @Test
    fun tappingPurpleScreen_navigatesToDetailAndShowsPurpleContent() {
        composeTestRule.onNodeWithTag("screen_card_5").performClick()

        composeTestRule.onNodeWithText("Purple Screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Items in Purple Screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Purple Item 1").assertIsDisplayed()
    }

    @Test
    fun backButton_returnsToHomeScreen() {
        composeTestRule.onNodeWithTag("screen_card_2").performClick()
        composeTestRule.onNodeWithText("Green Screen").assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("Back").performClick()

        composeTestRule.onNodeWithText("Main Screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Green Screen").assertIsDisplayed()
    }

    @Test
    fun homeScreen_isDisplayedInitially() {
        composeTestRule.onNodeWithTag("home_screen").assertIsDisplayed()
    }
}
