
/**
 * Copyright (c) 2014, dark_neo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * tv.java
 * @author dark_neo
 * @date 2014-10-14
 *
 */

/**
 * A small example to create a TreeView with child nodes in hard-mode
 * (not Netbeans or Eclipse GUI-toolkit aid) for hardcore developers :P
 *
 * Example take from:
 * http://docs.oracle.com/javase/tutorial/uiswing/components/tree.html
 */

package dn;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.*;
import java.util.ArrayList;

public class tv extends JPanel {
	private JTree _tree;
	private File[] _arr_dir;
	private static final short _SCREEN_WIDTH = 1366;
	private static final short _SCREEN_HEIGHT = 768;
	private static final short _WIDTH = 200;
	private static final short _HEIGHT = 350;
	private static final short _XPOS = (_SCREEN_WIDTH / 2);
	private static final short _YPOS = (_SCREEN_HEIGHT / 2);

	public tv()
	{
		super(new GridLayout(1, 0));
		try {
			_arr_dir = File.listRoots();

			/* root node */
			DefaultMutableTreeNode root = 
				new DefaultMutableTreeNode(
					_arr_dir[0].toString());
			this.create_nodes(root);
			_tree = new JTree(root);
			JScrollPane tree_view = new JScrollPane(_tree);
			super.add(tree_view);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void create_nodes(DefaultMutableTreeNode root)
	{
		DefaultMutableTreeNode category = null;
		DefaultMutableTreeNode book = null;

		/*
	       	root_node
			|_ c_programming_language
				|_c_and_unix
			|_ ethical_hacking_for_noobs
				|_break_wap_wireless_security
			|_ linux_kick_ass_windows
				|_why_linux_rocks
		*/

		for (int i = 0; i < _arr_dir.length; i++) {
			category = new DefaultMutableTreeNode(
					_arr_dir[i].toString());
			root.add(category);
		}

		/*
		category = new DefaultMutableTreeNode("c_programming_language");
		root.add(category);
		book = new DefaultMutableTreeNode("c_and_unix");
		category.add(book);

		category = new DefaultMutableTreeNode(
					"ethical_hacking_for_noobs");
		root.add(category);
		book = new DefaultMutableTreeNode(
			"break_wap_wireless_security");
		category.add(book);

		category = new DefaultMutableTreeNode(
				"linux_kick_ass_windows");
		root.add(category);
		book = new DefaultMutableTreeNode("why_linux_rocks");
		category.add(book);
		*/
	}

	private static void create_gui()
	{
		JFrame frame = new JFrame("TreeView demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Set window size */
		frame.setPreferredSize(new Dimension(_HEIGHT, _WIDTH));

		/* Set window location */
		frame.setLocation(_XPOS, _YPOS);

		/* Add content to the window */
		frame.add(new tv());

		/* Display the window */
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String args[])
	{
		/*
		 * Schedule a job for the event dispatch thread.
		 * Creating and showing this application's GUI.
		 *
		 * See this link for further details:
http://docs.oracle.com/javase/tutorial/uiswing/concurrency/dispatch.html
		 */
		javax.swing.SwingUtilities.invokeLater(
			new Runnable()
			{
				public void run()
				{
					create_gui();
				}
			}
		);
	}
}

