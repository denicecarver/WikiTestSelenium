package com.selenium.junit.wikitestrun;

import java.util.ArrayList;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class RunSuiteListener  extends RunListener {
	/**
	 * Called before any tests have been run.
	 * */
	public void testRunStarted(Description description)	throws java.lang.Exception
	{
		System.out.println("Number of testcases to execute: " + description.testCount());
		ArrayList<Description> children = description.getChildren();
		for (Description child : children) {
			System.out.println("Test suite:" + child.getClassName());
			ArrayList<Description> grandchildren = child.getChildren();
			if (grandchildren != null) {
				for (Description grandchild : grandchildren) {
					System.out.println("Test case:" + grandchild.getMethodName());
				}
			}
		}
	}

	/**
	 *  Called when all tests have finished
	 * */
	public void testRunFinished(Result result) throws java.lang.Exception
	{
		System.out.println("Number of testcases executed: " + result.getRunCount());
		System.out.println("Number of testcases failed: " + result.getFailureCount());
		System.out.println("Time to complete suite: " + result.getRunTime() + "ms");
	}

	/**
	 *  Called when an atomic test is about to be started.
	 * */
	public void testStarted(Description description) throws java.lang.Exception
	{
		System.out.println("Test case:  " + description.getMethodName());
	}
//
//	/**
//	 *  Called when an atomic test has finished, whether the test succeeds or fails.
//	 * */
//	public void testFinished(Description description) throws java.lang.Exception
//	{
//		System.out.println("Finished execution of test case: "+ description.getMethodName());
//	}

	/**
	 *  Called when an atomic test fails.
	 * */
	public void testFailure(Failure failure) throws java.lang.Exception
	{
		System.out.println("Failure Message:  " + failure.getMessage());
		System.out.println("Failure Description:  " + failure.getDescription());
		System.out.println("Failure Exception:  " + failure.getException());
	}
//
//	/**
//	 *  Called when a test will not be run, generally because a test method is annotated with Ignore.
//	 * */
//	public void testIgnored(Description description) throws java.lang.Exception
//	{
//		System.out.println("Execution of test case ignored: "+ description.getMethodName());
//	}

}
