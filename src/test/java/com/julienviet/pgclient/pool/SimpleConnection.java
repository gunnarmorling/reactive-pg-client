/*
 * Copyright (C) 2017 Julien Viet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.julienviet.pgclient.pool;

import com.julienviet.pgclient.impl.CommandBase;
import com.julienviet.pgclient.impl.Connection;

class SimpleConnection implements Connection {

  Holder holder;
  int closed;

  @Override
  public void init(Holder holder) {
    this.holder = holder;
  }

  @Override
  public boolean isSsl() {
    return false;
  }

  @Override
  public void close(Holder holder) {
    closed++;
  }

  void close() {
    holder.handleClosed();
  }

  @Override
  public void schedule(CommandBase<?> cmd) {
    throw new UnsupportedOperationException();
  }
}
