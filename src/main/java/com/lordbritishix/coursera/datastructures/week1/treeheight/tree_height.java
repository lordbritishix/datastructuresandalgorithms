package com.lordbritishix.coursera.datastructures.week1.treeheight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class tree_height {
	static class Node {
		private List<Node> nodes = new ArrayList<>();
		private int val;

		public void addNode(Node node) {
			nodes.add(node);
		}

		public void setVal(int val) {
			this.val = val;
		}

		public List<Node> getNodes() {
			return nodes;
		}

		public int getVal() {
			return val;
		}

		public int getMaxHeight() {
		    if (nodes.size() <= 0) {
		        return 1;
            }

            Queue<Node> buffer = new LinkedList<>();
            buffer.add(this);

            int height = 0;
            int nodeCount = 1;

            while (buffer.size() > 0) {
                int newNodeCount = 0;
                for (int x = 0; x < nodeCount; ++x) {
                    Node currentNode = buffer.remove();

                    newNodeCount += currentNode.getNodes().size();

                    for (Node node : currentNode.nodes) {
                        buffer.add(node);
                    }
                }

                nodeCount = newNodeCount;

                height++;
            }

            return height;
        }

		// does level-order traversal of the tree
		@Override
		public String toString() {
			if (nodes.size() <= 0) {
				return "";
			}

			StringBuilder stringBuilder = new StringBuilder();

			Queue<Node> buffer = new LinkedList<>();
			buffer.add(this);

			while (buffer.size() > 0) {
				Node currentNode = buffer.remove();

				stringBuilder.append(currentNode.getVal());
				stringBuilder.append(",");

				for (Node node : currentNode.nodes) {
					buffer.add(node);
				}
			}

			return stringBuilder.toString();
		}
	}

    private static class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	static class TreeHeight {
		int n;
		int parent[];

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		Node constructTree(int[] input) {
			int rootIdx = -1;
			Node nodes[] = new Node[input.length];

			for (int x = 0; x < nodes.length; ++x) {
				nodes[x] = new Node();
				nodes[x].setVal(x);
			}

			for (int childIdx = 0; childIdx < input.length; ++childIdx) {
				int parentIdx = input[childIdx];
				if (input[childIdx] == -1) {
					rootIdx = childIdx;
				} else {
					nodes[parentIdx].addNode(nodes[childIdx]);
				}
			}

			return nodes[rootIdx];
		}

		int computeHeight() {
			return constructTree(parent).getMaxHeight();
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
