/*
 * Copyright (c) 2020, <GiacomoSorbi> All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE. The views and conclusions contained in the
 * software and documentation are those of the authors and should not be
 * interpreted as representing official policies, either expressed or implied,
 * of the FreeBSD Project.
 */

package _02_IntroToQueues;

import java.util.ArrayDeque;

/*
 * Complete the calculateWaitTime() method here!
 * Instructions are in the BaseBallTicketsTest class.
 */

public class _02_BaseballTickets {
	public static int calculateWaitTime(ArrayDeque<Integer> ticketsQueue, int position) {
		int decrementFriend = ticketsQueue.size();
		int time = 0;
		int friendTickets = 0;

//		System.out.println("Orinial queue: " + ticketsQueue);
//		System.out.println("First Value" + ticketsQueue.getFirst());
//		System.out.println("pop" + ticketsQueue.pop());
//		System.out.println("popped queue: " + ticketsQueue);
//		System.out.println("Add " + ticketsQueue.add(2));
//		System.out.println("add queue: " + ticketsQueue);
		if (position != 0) {
			for (int i = 0; i < position; i++) {
				ticketsQueue.add(ticketsQueue.pop()-1);
				
				time += 1;
				System.out.println(ticketsQueue);
			}
			friendTickets = ticketsQueue.getFirst();
			decrementFriend = 0;
		}

		 else {
			decrementFriend = 0;
			friendTickets = ticketsQueue.getFirst();
		}


		while (friendTickets !=0) {
			System.out.println(friendTickets);
			System.out.println(decrementFriend);
			if (decrementFriend == 0) {
				friendTickets -= 1;
				if (friendTickets == 0) {
				    break;
				}
				ticketsQueue.add(ticketsQueue.pop()-1);

				time += 1;
				decrementFriend = ticketsQueue.size();

			} else {
				if (ticketsQueue.getFirst() >0) {
					
					ticketsQueue.add(ticketsQueue.pop()-1);
					time += 1;
					decrementFriend -= 1;

				} else {
					ticketsQueue.remove();
					decrementFriend -= 1;
					time += 1;

				}

			}
		}
		return time;
	}
}
