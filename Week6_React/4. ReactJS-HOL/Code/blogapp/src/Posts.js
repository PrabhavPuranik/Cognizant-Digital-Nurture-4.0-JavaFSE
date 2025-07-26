import React from 'react';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => this.setState({ posts: data }))
      .catch(error => this.setState({ error }));
  }

  componentDidMount() {
    this.loadPosts();
  }

  render() {
    if (this.state.error) {
      return <div>Error: {this.state.error.message}</div>;
    }

    return (
      <div>
        <h2>Posts</h2>
        <ul style={{ listStyleType: 'none', paddingLeft: 0 }}>
          {this.state.posts.map((post, index) => (
            <React.Fragment key={post.id}>
              <li>{post.title}</li>
              {index !== this.state.posts.length - 1 && <hr />}
            </React.Fragment>
          ))}
        </ul>
      </div>
    );
  }

  componentDidCatch(error, info) {
    console.log('Error caught:', error, info);
  }
}

export default Posts;
