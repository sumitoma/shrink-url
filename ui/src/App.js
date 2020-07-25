import React, { Component } from "react";
import AppHeaderBar from "./components/AppHeaderBar";
import pages from "./pages/pages";
import theme from "./theme";
import { withStyles, createMuiTheme, ThemeProvider } from "@material-ui/core/styles";
import {
  BrowserRouter as Router,
  Route,
  Switch
} from "react-router-dom";



const customTheme = createMuiTheme(theme);

class App extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <ThemeProvider theme={customTheme}>
          <Router>
          <AppHeaderBar />
          <div style={{textAlign: 'center'}}>
            <Switch>
            {
                pages.map( page => <Route exact key={page.to} 
                path={page.to} component={page.page} />)
            }
            </Switch>
          </div>
        </Router>
      </ThemeProvider>
    );
  }
}

export default App;
